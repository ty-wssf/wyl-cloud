package com.wyl.upms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.wyl.common.core.catchlog.CatchAndLog;
import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.exception.Assert;
import cn.wyl.common.core.exception.BizException;
import cn.wyl.common.datascope.DataScope;
import cn.wyl.common.security.SecurityUtils;
import com.wyl.upms.domain.gateway.*;
import com.wyl.upms.dto.clientobject.SysUserCO;
import com.wyl.upms.dto.command.SysUserAddCommand;
import com.wyl.upms.dto.command.SysUserEditCommand;
import com.wyl.upms.dto.qry.SysUserPageQry;
import com.wyl.upms.dto.qry.SysUserQry;
import com.wyl.upms.gatewayimpl.database.dataobject.*;
import com.wyl.upms.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 13:22:50
 */
@Transactional
@Validated
@Service
@CatchAndLog
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserGateway sysUserGateway;
    @Resource
    private SysPostGateway postGateway;
    @Resource
    private SysRoleGateway sysRoleGateway;
    @Resource
    private SysUserPostGateway userPostGateway;
    @Resource
    private SysUserRoleGateway userRoleGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysUserCO> queryByPrimaryKey(Long primaryKey) {
        SysUser sysUser = this.sysUserGateway.queryByPrimaryKey(primaryKey);
        List<SysPost> sysPosts = postGateway.queryPostsByUserId(sysUser.getUserId());
        List<SysRole> sysRoles = sysRoleGateway.queryRolesByUserId(sysUser.getUserId());
        SysUserCO sysUserCO = new SysUserCO();
        BeanUtil.copyProperties(sysUser, sysUserCO);
        sysUserCO.setPostIds(sysPosts.stream().mapToLong(SysPost::getPostId).toArray());
        sysUserCO.setRoleIds(sysRoles.stream().mapToLong(SysRole::getRoleId).toArray());
        return SingleResponse.of(sysUserCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysUserCO> queryAll(SysUserQry qry) {
        SysUser sysUserDO = new SysUser();
        BeanUtil.copyProperties(qry, sysUserDO);
        List<SysUser> sysUserList = sysUserGateway.queryAll(sysUserDO);
        List<SysUserCO> sysUserCOList = sysUserList.stream().map(sysUser -> {
            SysUserCO sysUserCO = new SysUserCO();
            BeanUtil.copyProperties(sysUser, sysUserCO);
            return sysUserCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysUserCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @DataScope(deptAlias = "d", userAlias = "u")
    @Override
    public PageResponse<SysUserCO> queryPage(SysUserPageQry pageQry) {
        SysUser sysUserDO = new SysUser();
        BeanUtil.copyProperties(pageQry, sysUserDO);
        PageResponse<SysUser> pageResponse = sysUserGateway.queryPage(sysUserDO);
        List<SysUser> sysUserList = pageResponse.getData();
        List<SysUserCO> sysUserCOList = sysUserList.stream().map(sysUser -> {
            SysUserCO sysUserCO = new SysUserCO();
            BeanUtil.copyProperties(sysUser, sysUserCO);
            return sysUserCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysUserCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增用户
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysUserAddCommand command) {
        // 校验
        Assert.isTrue(checkUserNameUnique(command.getUserName()).getData(), "新增用户'" + command.getUserName() + "'失败，登录账号已存在");
        Assert.isTrue(checkPhoneUnique(command.getPhonenumber()).getData(), "新增用户'" + command.getUserName() + "'失败，手机号码已存在");
        Assert.isTrue(checkEmailUnique(command.getEmail()).getData(), "新增用户'" + command.getUserName() + "'失败，邮箱账号已存在");

        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(command, sysUser);
        // 密码加密
        sysUser.setPassword(SecurityUtils.encryptPassword(sysUser.getPassword()));
        insertUser(sysUser);
        return Response.buildSuccess();
    }

    /**
     * 修改用户
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysUserEditCommand command) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(command, sysUser);

        // 校验用户是否允许操作
        checkUserAllowed(sysUser);
        // 校验
        Assert.isTrue(checkPhoneUnique(sysUser).getData(), "修改用户'" + command.getUserName() + "'失败，手机号码已存在");
        Assert.isTrue(checkEmailUnique(sysUser).getData(), "修改用户'" + command.getUserName() + "'失败，邮箱账号已存在");

        Long userId = sysUser.getUserId();
        // 删除用户与角色关联
        userRoleGateway.deleteUserRoleByUserId(userId);
        // 新增用户与角色管理
        insertUserRole(sysUser);
        // 删除用户与岗位关联
        userPostGateway.deleteUserPostByUserId(userId);
        // 新增用户与岗位管理
        insertUserPost(sysUser);
        this.sysUserGateway.update(sysUser);
        return Response.buildSuccess();
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    @Override
    public Response deleteByPrimaryKeys(Long[] primaryKeys) {
        Assert.isFalse(ArrayUtil.contains(primaryKeys, SecurityUtils.getLoginUser().getUserId()), "当前用户不能删除");
        for (Long userId : primaryKeys) {
            SysUser sysUser = new SysUser();
            sysUser.setUserId(userId);
            checkUserAllowed(sysUser);
        }
        // 删除用户与角色关联
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.userRoleGateway.deleteUserRoleByUserId(primaryKey));
        // 删除用户与岗位关联
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.userPostGateway.deleteUserPostByUserId(primaryKey));
        // 删除用户信息
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysUserGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }

    @Override
    public SingleResponse<Boolean> checkUserNameUnique(String userName) {
        return SingleResponse.of(ObjectUtil.isEmpty(sysUserGateway.queryByUserName(userName)));
    }

    @Override
    public SingleResponse<Boolean> checkPhoneUnique(String phone) {
        return SingleResponse.of(ObjectUtil.isEmpty(sysUserGateway.queryByPhonenumber(phone)));
    }

    @Override
    public SingleResponse<Boolean> checkEmailUnique(String email) {
        return SingleResponse.of(ObjectUtil.isEmpty(sysUserGateway.queryByEmail(email)));
    }

    @Override
    public SingleResponse<Boolean> checkPhoneUnique(SysUser sysUser) {
        SysUser info = sysUserGateway.queryByPhonenumber(sysUser.getPhonenumber());
        if (ObjectUtil.isNotNull(info) && info.getUserId().longValue() != sysUser.getUserId()) {
            return SingleResponse.of(false);
        }
        return SingleResponse.of(true);
    }

    @Override
    public SingleResponse<Boolean> checkEmailUnique(SysUser sysUser) {
        SysUser info = sysUserGateway.queryByEmail(sysUser.getEmail());
        if (ObjectUtil.isNotNull(info) && info.getUserId().longValue() != sysUser.getUserId()) {
            return SingleResponse.of(false);
        }
        return SingleResponse.of(true);
    }

    @Override
    public void insertUser(SysUser user) {
        // 新增用户信息
        sysUserGateway.insert(user);
        // 新增用户岗位关联
        insertUserPost(user);
        // 新增用户与角色管理
        insertUserRole(user);
    }

    /**
     * 新增用户岗位信息
     *
     * @param user 用户对象
     */
    public void insertUserPost(SysUser user) {
        Long[] posts = user.getPostIds();
        if (ObjectUtil.isNotNull(posts)) {
            // 新增用户与岗位管理
            List<SysUserPost> list = new ArrayList<SysUserPost>();
            for (Long postId : posts) {
                SysUserPost up = new SysUserPost();
                up.setUserId(user.getUserId());
                up.setPostId(postId);
                list.add(up);
            }
            if (list.size() > 0) {
                userPostGateway.insertBatch(list);
            }
        }
    }

    /**
     * 新增用户角色信息
     *
     * @param user 用户对象
     */
    public void insertUserRole(SysUser user) {
        Long[] roles = user.getRoleIds();
        if (ObjectUtil.isNotNull(roles)) {
            // 新增用户与角色管理
            List<SysUserRole> list = new ArrayList<SysUserRole>();
            for (Long roleId : roles) {
                SysUserRole ur = new SysUserRole();
                ur.setUserId(user.getUserId());
                ur.setRoleId(roleId);
                list.add(ur);
            }
            if (list.size() > 0) {
                userRoleGateway.insertBatch(list);
            }
        }
    }

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    @Override
    public void checkUserAllowed(SysUser user) {
        if (ObjectUtil.isNotEmpty(user.getUserId()) && user.isAdmin()) {
            throw new BizException("不允许操作超级管理员用户");
        }
    }

    @Override
    public Response resetPwd(SysUser user) {
        checkUserAllowed(user);
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        sysUserGateway.update(user);
        return Response.buildSuccess();
    }

}
