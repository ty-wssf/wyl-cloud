package com.wyl.upms.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.upms.gatewayimpl.database.dataobject.SysMenu;
import com.wyl.upms.dto.clientobject.SysMenuCO;
import com.wyl.upms.dto.qry.SysMenuQry;
import com.wyl.upms.dto.qry.SysMenuPageQry;
import com.wyl.upms.dto.command.SysMenuAddCommand;
import com.wyl.upms.dto.command.SysMenuEditCommand;
import com.wyl.upms.domain.gateway.SysMenuGateway;
import com.wyl.upms.service.SysMenuService;
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
 * 菜单权限表(SysMenu)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 13:21:38
 */
@Validated
@Service
@CatchAndLog
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuGateway sysMenuGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysMenuCO> queryByPrimaryKey(Long primaryKey) {
        SysMenu sysMenu = this.sysMenuGateway.queryByPrimaryKey(primaryKey);
        SysMenuCO sysMenuCO = new SysMenuCO();
        BeanUtil.copyProperties(sysMenu, sysMenuCO);
        return SingleResponse.of(sysMenuCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysMenuCO> queryAll(SysMenuQry qry) {
        SysMenu sysMenuDO = new SysMenu();
        BeanUtil.copyProperties(qry, sysMenuDO);
        List<SysMenu> sysMenuList = sysMenuGateway.queryAll(sysMenuDO);
        List<SysMenuCO> sysMenuCOList = sysMenuList.stream().map(sysMenu -> {
            SysMenuCO sysMenuCO = new SysMenuCO();
            BeanUtil.copyProperties(sysMenu, sysMenuCO);
            return sysMenuCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysMenuCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysMenuCO> queryPage(SysMenuPageQry pageQry) {
        SysMenu sysMenuDO = new SysMenu();
        BeanUtil.copyProperties(pageQry, sysMenuDO);
        PageResponse<SysMenu> pageResponse = sysMenuGateway.queryPage(sysMenuDO);
        List<SysMenu> sysMenuList = pageResponse.getData();
        List<SysMenuCO> sysMenuCOList = sysMenuList.stream().map(sysMenu -> {
            SysMenuCO sysMenuCO = new SysMenuCO();
            BeanUtil.copyProperties(sysMenu, sysMenuCO);
            return sysMenuCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysMenuCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysMenuAddCommand command) {
        SysMenu sysMenu = new SysMenu();
        BeanUtil.copyProperties(command, sysMenu);
        this.sysMenuGateway.insert(sysMenu);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysMenuEditCommand command) {
        SysMenu sysMenu = new SysMenu();
        BeanUtil.copyProperties(command, sysMenu);
        this.sysMenuGateway.update(sysMenu);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysMenuGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
