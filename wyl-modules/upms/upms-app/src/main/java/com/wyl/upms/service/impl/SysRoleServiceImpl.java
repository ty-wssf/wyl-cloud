package com.wyl.upms.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.upms.gatewayimpl.database.dataobject.SysRole;
import com.wyl.upms.dto.clientobject.SysRoleCO;
import com.wyl.upms.dto.qry.SysRoleQry;
import com.wyl.upms.dto.qry.SysRolePageQry;
import com.wyl.upms.dto.command.SysRoleAddCommand;
import com.wyl.upms.dto.command.SysRoleEditCommand;
import com.wyl.upms.domain.gateway.SysRoleGateway;
import com.wyl.upms.service.SysRoleService;
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
 * 角色信息表(SysRole)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 13:22:38
 */
@Validated
@Service
@CatchAndLog
public class SysRoleServiceImpl implements SysRoleService {
    @Resource
    private SysRoleGateway sysRoleGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysRoleCO> queryByPrimaryKey(Long primaryKey) {
        SysRole sysRole = this.sysRoleGateway.queryByPrimaryKey(primaryKey);
        SysRoleCO sysRoleCO = new SysRoleCO();
        BeanUtil.copyProperties(sysRole, sysRoleCO);
        return SingleResponse.of(sysRoleCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysRoleCO> queryAll(SysRoleQry qry) {
        SysRole sysRoleDO = new SysRole();
        BeanUtil.copyProperties(qry, sysRoleDO);
        List<SysRole> sysRoleList = sysRoleGateway.queryAll(sysRoleDO);
        List<SysRoleCO> sysRoleCOList = sysRoleList.stream().map(sysRole -> {
            SysRoleCO sysRoleCO = new SysRoleCO();
            BeanUtil.copyProperties(sysRole, sysRoleCO);
            return sysRoleCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysRoleCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysRoleCO> queryPage(SysRolePageQry pageQry) {
        SysRole sysRoleDO = new SysRole();
        BeanUtil.copyProperties(pageQry, sysRoleDO);
        PageResponse<SysRole> pageResponse = sysRoleGateway.queryPage(sysRoleDO);
        List<SysRole> sysRoleList = pageResponse.getData();
        List<SysRoleCO> sysRoleCOList = sysRoleList.stream().map(sysRole -> {
            SysRoleCO sysRoleCO = new SysRoleCO();
            BeanUtil.copyProperties(sysRole, sysRoleCO);
            return sysRoleCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysRoleCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysRoleAddCommand command) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(command, sysRole);
        this.sysRoleGateway.insert(sysRole);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysRoleEditCommand command) {
        SysRole sysRole = new SysRole();
        BeanUtil.copyProperties(command, sysRole);
        this.sysRoleGateway.update(sysRole);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysRoleGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
