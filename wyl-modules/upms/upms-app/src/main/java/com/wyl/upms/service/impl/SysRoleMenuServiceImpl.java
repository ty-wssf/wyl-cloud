package com.wyl.upms.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.upms.gatewayimpl.database.dataobject.SysRoleMenu;
import com.wyl.upms.dto.clientobject.SysRoleMenuCO;
import com.wyl.upms.dto.qry.SysRoleMenuQry;
import com.wyl.upms.dto.qry.SysRoleMenuPageQry;
import com.wyl.upms.dto.command.SysRoleMenuAddCommand;
import com.wyl.upms.dto.command.SysRoleMenuEditCommand;
import com.wyl.upms.domain.gateway.SysRoleMenuGateway;
import com.wyl.upms.service.SysRoleMenuService;
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
 * 角色和菜单关联表(SysRoleMenu)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 13:22:41
 */
@Validated
@Service
@CatchAndLog
public class SysRoleMenuServiceImpl implements SysRoleMenuService {
    @Resource
    private SysRoleMenuGateway sysRoleMenuGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysRoleMenuCO> queryByPrimaryKey(Long primaryKey) {
        SysRoleMenu sysRoleMenu = this.sysRoleMenuGateway.queryByPrimaryKey(primaryKey);
        SysRoleMenuCO sysRoleMenuCO = new SysRoleMenuCO();
        BeanUtil.copyProperties(sysRoleMenu, sysRoleMenuCO);
        return SingleResponse.of(sysRoleMenuCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysRoleMenuCO> queryAll(SysRoleMenuQry qry) {
        SysRoleMenu sysRoleMenuDO = new SysRoleMenu();
        BeanUtil.copyProperties(qry, sysRoleMenuDO);
        List<SysRoleMenu> sysRoleMenuList = sysRoleMenuGateway.queryAll(sysRoleMenuDO);
        List<SysRoleMenuCO> sysRoleMenuCOList = sysRoleMenuList.stream().map(sysRoleMenu -> {
            SysRoleMenuCO sysRoleMenuCO = new SysRoleMenuCO();
            BeanUtil.copyProperties(sysRoleMenu, sysRoleMenuCO);
            return sysRoleMenuCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysRoleMenuCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysRoleMenuCO> queryPage(SysRoleMenuPageQry pageQry) {
        SysRoleMenu sysRoleMenuDO = new SysRoleMenu();
        BeanUtil.copyProperties(pageQry, sysRoleMenuDO);
        PageResponse<SysRoleMenu> pageResponse = sysRoleMenuGateway.queryPage(sysRoleMenuDO);
        List<SysRoleMenu> sysRoleMenuList = pageResponse.getData();
        List<SysRoleMenuCO> sysRoleMenuCOList = sysRoleMenuList.stream().map(sysRoleMenu -> {
            SysRoleMenuCO sysRoleMenuCO = new SysRoleMenuCO();
            BeanUtil.copyProperties(sysRoleMenu, sysRoleMenuCO);
            return sysRoleMenuCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysRoleMenuCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysRoleMenuAddCommand command) {
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        BeanUtil.copyProperties(command, sysRoleMenu);
        this.sysRoleMenuGateway.insert(sysRoleMenu);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysRoleMenuEditCommand command) {
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        BeanUtil.copyProperties(command, sysRoleMenu);
        this.sysRoleMenuGateway.update(sysRoleMenu);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysRoleMenuGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
