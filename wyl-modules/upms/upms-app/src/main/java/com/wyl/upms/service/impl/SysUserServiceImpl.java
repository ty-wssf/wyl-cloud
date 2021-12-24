package com.wyl.upms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.wyl.common.core.catchlog.CatchAndLog;
import cn.wyl.common.datascope.DataScope;
import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.upms.domain.gateway.SysPostGateway;
import com.wyl.upms.domain.gateway.SysRoleGateway;
import com.wyl.upms.domain.gateway.SysUserGateway;
import com.wyl.upms.dto.clientobject.SysUserCO;
import com.wyl.upms.dto.command.SysUserAddCommand;
import com.wyl.upms.dto.command.SysUserEditCommand;
import com.wyl.upms.dto.qry.SysUserPageQry;
import com.wyl.upms.dto.qry.SysUserQry;
import com.wyl.upms.gatewayimpl.database.dataobject.SysPost;
import com.wyl.upms.gatewayimpl.database.dataobject.SysRole;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUser;
import com.wyl.upms.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户信息表(SysUser)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 13:22:50
 */
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
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysUserAddCommand command) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(command, sysUser);
        this.sysUserGateway.insert(sysUser);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysUserEditCommand command) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(command, sysUser);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysUserGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
