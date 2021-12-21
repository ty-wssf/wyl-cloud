package com.wyl.upms.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.upms.gatewayimpl.database.dataobject.SysRoleDept;
import com.wyl.upms.dto.clientobject.SysRoleDeptCO;
import com.wyl.upms.dto.qry.SysRoleDeptQry;
import com.wyl.upms.dto.qry.SysRoleDeptPageQry;
import com.wyl.upms.dto.command.SysRoleDeptAddCommand;
import com.wyl.upms.dto.command.SysRoleDeptEditCommand;
import com.wyl.upms.domain.gateway.SysRoleDeptGateway;
import com.wyl.upms.service.SysRoleDeptService;
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
 * 角色和部门关联表(SysRoleDept)表服务实现类
 *
 * @author wyl
 * @since 2021-12-21 13:22:40
 */
@Validated
@Service
@CatchAndLog
public class SysRoleDeptServiceImpl implements SysRoleDeptService {
    @Resource
    private SysRoleDeptGateway sysRoleDeptGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysRoleDeptCO> queryByPrimaryKey(Long primaryKey) {
        SysRoleDept sysRoleDept = this.sysRoleDeptGateway.queryByPrimaryKey(primaryKey);
        SysRoleDeptCO sysRoleDeptCO = new SysRoleDeptCO();
        BeanUtil.copyProperties(sysRoleDept, sysRoleDeptCO);
        return SingleResponse.of(sysRoleDeptCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysRoleDeptCO> queryAll(SysRoleDeptQry qry) {
        SysRoleDept sysRoleDeptDO = new SysRoleDept();
        BeanUtil.copyProperties(qry, sysRoleDeptDO);
        List<SysRoleDept> sysRoleDeptList = sysRoleDeptGateway.queryAll(sysRoleDeptDO);
        List<SysRoleDeptCO> sysRoleDeptCOList = sysRoleDeptList.stream().map(sysRoleDept -> {
            SysRoleDeptCO sysRoleDeptCO = new SysRoleDeptCO();
            BeanUtil.copyProperties(sysRoleDept, sysRoleDeptCO);
            return sysRoleDeptCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysRoleDeptCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysRoleDeptCO> queryPage(SysRoleDeptPageQry pageQry) {
        SysRoleDept sysRoleDeptDO = new SysRoleDept();
        BeanUtil.copyProperties(pageQry, sysRoleDeptDO);
        PageResponse<SysRoleDept> pageResponse = sysRoleDeptGateway.queryPage(sysRoleDeptDO);
        List<SysRoleDept> sysRoleDeptList = pageResponse.getData();
        List<SysRoleDeptCO> sysRoleDeptCOList = sysRoleDeptList.stream().map(sysRoleDept -> {
            SysRoleDeptCO sysRoleDeptCO = new SysRoleDeptCO();
            BeanUtil.copyProperties(sysRoleDept, sysRoleDeptCO);
            return sysRoleDeptCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysRoleDeptCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysRoleDeptAddCommand command) {
        SysRoleDept sysRoleDept = new SysRoleDept();
        BeanUtil.copyProperties(command, sysRoleDept);
        this.sysRoleDeptGateway.insert(sysRoleDept);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysRoleDeptEditCommand command) {
        SysRoleDept sysRoleDept = new SysRoleDept();
        BeanUtil.copyProperties(command, sysRoleDept);
        this.sysRoleDeptGateway.update(sysRoleDept);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysRoleDeptGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
