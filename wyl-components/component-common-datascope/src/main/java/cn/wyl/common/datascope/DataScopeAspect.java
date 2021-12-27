package cn.wyl.common.datascope;

import cn.hutool.extra.spring.SpringUtil;
import cn.wyl.common.core.dto.Query;
import cn.wyl.common.core.tree.TreeSupport;
import cn.wyl.common.security.LoginUser;
import cn.wyl.common.security.Role;
import cn.wyl.common.security.SecurityUtils;
import com.wyl.upms.api.RemoteDeptService;
import com.wyl.upms.dto.clientobject.SysDeptTreeCO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据过滤处理
 *
 * @author ruoyi
 */
@Aspect
@Component
public class DataScopeAspect {
    /**
     * 全部数据权限
     */
    public static final String DATA_SCOPE_ALL = "1";

    /**
     * 自定数据权限
     */
    public static final String DATA_SCOPE_CUSTOM = "2";

    /**
     * 部门数据权限
     */
    public static final String DATA_SCOPE_DEPT = "3";

    /**
     * 部门及以下数据权限
     */
    public static final String DATA_SCOPE_DEPT_AND_CHILD = "4";

    /**
     * 仅本人数据权限
     */
    public static final String DATA_SCOPE_SELF = "5";

    /**
     * 数据权限过滤关键字
     */
    public static final String DATA_SCOPE = "dataScope";

    @Before("@annotation(controllerDataScope)")
    public void doBefore(JoinPoint point, DataScope controllerDataScope) throws Throwable {
        clearDataScope(point);
        handleDataScope(point, controllerDataScope);
    }

    protected void handleDataScope(final JoinPoint joinPoint, DataScope controllerDataScope) {
        // 获取当前的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        loginUser = new LoginUser();
        loginUser.setDeptId(100L);
        Role role1 = new Role();
        role1.setDataScope("4");
        // loginUser.addRole(role1);
        // 如果是超级管理员，则不过滤数据
        if (loginUser != null && !loginUser.isAdmin()) {
            dataScopeFilter(joinPoint, loginUser, controllerDataScope.deptAlias(),
                    controllerDataScope.userAlias());
        }
    }

    /**
     * 数据范围过滤
     *
     * @param joinPoint 切点
     * @param user      用户
     * @param deptAlias 部门别名
     * @param userAlias 用户别名
     */
    public static void dataScopeFilter(JoinPoint joinPoint, LoginUser user, String deptAlias, String userAlias) {
        StringBuilder sqlString = new StringBuilder();

        for (Role role : user.getRoles()) {
            String dataScope = role.getDataScope();
            if (DATA_SCOPE_ALL.equals(dataScope)) {
                sqlString = new StringBuilder();
                break;
            } else if (DATA_SCOPE_CUSTOM.equals(dataScope)) {
                sqlString.append(String.format(" OR %s.dept_id IN ( SELECT dept_id FROM sys_role_dept WHERE role_id = %s ) ",
                        deptAlias, role.getRoleId()));
            } else if (DATA_SCOPE_DEPT.equals(dataScope)) {
                sqlString.append(String.format(" OR %s.dept_id = %s ", deptAlias, user.getDeptId()));
            } else if (DATA_SCOPE_DEPT_AND_CHILD.equals(dataScope)) {
                List<SysDeptTreeCO> sysDeptCOList = SpringUtil.getBean(RemoteDeptService.class).treeList().getData();
                List<SysDeptTreeCO> root = new ArrayList<>();
                TreeSupport.forEach(sysDeptCOList, node -> {
                    if (user.getDeptId().equals(node.getId())) {
                        root.add(node);
                    }
                });
                List<String> subList = new ArrayList<>();
                TreeSupport.forEach(root, node -> {
                    subList.add(String.valueOf(node.getId()));
                });
                sqlString.append(String.format(
                        " OR %s.dept_id IN ( %s )",
                        deptAlias, "'" + String.join(",", subList).replace(",", "','") + "'"));
            } else if (DATA_SCOPE_SELF.equals(dataScope)) {
                if (userAlias != null && userAlias.length() > 0) {
                    sqlString.append(String.format(" OR %s.user_id = %s ", userAlias, user.getUserId()));
                } else {
                    // 数据权限为仅本人且没有userAlias别名不查询任何数据
                    sqlString.append(" OR 1=0 ");
                }
            }
        }

        if (sqlString.toString().length() > 0) {
            Object params = joinPoint.getArgs()[0];
            if (params != null && params instanceof Query) {
                Query query = (Query) params;
                query.getParams().put(DATA_SCOPE, " AND (" + sqlString.substring(4) + ")");
            }
        }
    }

    /**
     * 拼接权限sql前先清空params.dataScope参数防止注入
     */
    private void clearDataScope(final JoinPoint joinPoint) {
        Object params = joinPoint.getArgs()[0];
        if (params != null && params instanceof Query) {
            Query query = (Query) params;
            query.getParams().put(DATA_SCOPE, "");
        }
    }

}
