package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUserRole;
import com.wyl.upms.domain.gateway.SysUserRoleGateway;
import com.wyl.upms.gatewayimpl.database.SysUserRoleDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户和角色关联表(SysUserRole)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:54
 */
@Component
public class SysUserRoleGatewayImpl implements SysUserRoleGateway {

    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysUserRole queryByPrimaryKey(Long primaryKey) {
        SysUserRole sysUserRole = this.sysUserRoleDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysUserRole, "查询对象不存在");
        return sysUserRole;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserRole 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysUserRole> queryAll(SysUserRole sysUserRole) {
        return this.sysUserRoleDao.queryAll(sysUserRole);
    }

    /**
     * 查询单条数据
     *
     * @param sysUserRole 实例对象
     * @return
     */
    @Override
    public SysUserRole queryOne(SysUserRole sysUserRole) {
        List<SysUserRole> list = this.sysUserRoleDao.queryAll(sysUserRole);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserRole 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysUserRole> queryPage(SysUserRole sysUserRole) {
        PageHelper.startPage(sysUserRole.getPageQuery().getPageIndex(), sysUserRole.getPageQuery().getPageSize());
        List<SysUserRole> list = sysUserRoleDao.queryAll(sysUserRole);
        PageInfo<SysUserRole> pageInfo = new PageInfo<SysUserRole>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysUserRole sysUserRole) {
        sysUserRoleDao.insert(sysUserRole);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserRole> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysUserRole> entities) {
        entities.forEach(this::insert);
    }

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysUserRole sysUserRole) {
        Assert.isTrue(sysUserRoleDao.update(sysUserRole) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysUserRoleDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

    @Override
    public void deleteUserRoleByUserId(Long userId) {
        sysUserRoleDao.deleteUserRoleByUserId(userId);
    }

}

