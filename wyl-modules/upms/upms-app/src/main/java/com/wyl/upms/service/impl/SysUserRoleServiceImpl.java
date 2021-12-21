package com.wyl.upms.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUserRole;
import com.wyl.upms.dto.clientobject.SysUserRoleCO;
import com.wyl.upms.dto.qry.SysUserRoleQry;
import com.wyl.upms.dto.qry.SysUserRolePageQry;
import com.wyl.upms.dto.command.SysUserRoleAddCommand;
import com.wyl.upms.dto.command.SysUserRoleEditCommand;
import com.wyl.upms.domain.gateway.SysUserRoleGateway;
import com.wyl.upms.service.SysUserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import cn.hutool.core.bean.BeanUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import javax.validation.Valid;
import java.util.stream.Collectors;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;

/**
 * 用户和角色关联表(SysUserRole)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 13:22:54
 */
@Validated
@Service
@CatchAndLog
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleGateway sysUserRoleGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysUserRoleCO> queryByPrimaryKey(Long primaryKey) {
        SysUserRole sysUserRole = this.sysUserRoleGateway.queryByPrimaryKey(primaryKey);
        SysUserRoleCO sysUserRoleCO = new SysUserRoleCO();
        BeanUtil.copyProperties(sysUserRole, sysUserRoleCO);
        return SingleResponse.of(sysUserRoleCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysUserRoleCO> queryAll(SysUserRoleQry qry) {
        SysUserRole sysUserRoleDO = new SysUserRole();
        BeanUtil.copyProperties(qry, sysUserRoleDO);
        List<SysUserRole> sysUserRoleList = sysUserRoleGateway.queryAll(sysUserRoleDO);
        List<SysUserRoleCO> sysUserRoleCOList = sysUserRoleList.stream().map(sysUserRole -> {
            SysUserRoleCO sysUserRoleCO = new SysUserRoleCO();
            BeanUtil.copyProperties(sysUserRole, sysUserRoleCO);
            return sysUserRoleCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysUserRoleCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysUserRoleCO> queryPage(SysUserRolePageQry pageQry) {
        SysUserRole sysUserRoleDO = new SysUserRole();
        BeanUtil.copyProperties(pageQry, sysUserRoleDO);
        PageResponse<SysUserRole> pageResponse = sysUserRoleGateway.queryPage(sysUserRoleDO);
        List<SysUserRole> sysUserRoleList = pageResponse.getData();
        List<SysUserRoleCO> sysUserRoleCOList = sysUserRoleList.stream().map(sysUserRole -> {
            SysUserRoleCO sysUserRoleCO = new SysUserRoleCO();
            BeanUtil.copyProperties(sysUserRole, sysUserRoleCO);
            return sysUserRoleCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysUserRoleCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysUserRoleAddCommand command) {
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtil.copyProperties(command, sysUserRole);
        this.sysUserRoleGateway.insert(sysUserRole);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysUserRoleEditCommand command) {
        SysUserRole sysUserRole = new SysUserRole();
        BeanUtil.copyProperties(command, sysUserRole);
        this.sysUserRoleGateway.update(sysUserRole);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysUserRoleGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
