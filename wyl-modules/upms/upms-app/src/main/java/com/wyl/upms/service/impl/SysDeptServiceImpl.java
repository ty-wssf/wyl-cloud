package com.wyl.upms.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.wyl.common.core.catchlog.CatchAndLog;
import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.upms.domain.gateway.SysDeptGateway;
import com.wyl.upms.dto.clientobject.SysDeptCO;
import com.wyl.upms.dto.command.SysDeptAddCommand;
import com.wyl.upms.dto.command.SysDeptEditCommand;
import com.wyl.upms.dto.qry.SysDeptPageQry;
import com.wyl.upms.dto.qry.SysDeptQry;
import com.wyl.upms.gatewayimpl.database.dataobject.SysDept;
import com.wyl.upms.service.SysDeptService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 部门表(SysDept)表服务实现类
 *
 * @author wyl
 * @since 2021-12-20 16:10:13
 */
@Validated
@Service
@CatchAndLog
public class SysDeptServiceImpl implements SysDeptService {
    @Resource
    private SysDeptGateway sysDeptGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysDeptCO> queryByPrimaryKey(Long primaryKey) {
        SysDept sysDept = this.sysDeptGateway.queryByPrimaryKey(primaryKey);
        SysDeptCO sysDeptCO = new SysDeptCO();
        BeanUtil.copyProperties(sysDept, sysDeptCO);
        return SingleResponse.of(sysDeptCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysDeptCO> queryAll(SysDeptQry qry) {
        SysDept sysDeptDO = new SysDept();
        BeanUtil.copyProperties(qry, sysDeptDO);
        List<SysDept> sysDeptList = sysDeptGateway.queryAll(sysDeptDO);
        List<SysDeptCO> sysDeptCOList = sysDeptList.stream().map(sysDept -> {
            SysDeptCO sysDeptCO = new SysDeptCO();
            BeanUtil.copyProperties(sysDept, sysDeptCO);
            return sysDeptCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysDeptCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysDeptCO> queryPage(SysDeptPageQry pageQry) {
        SysDept sysDeptDO = new SysDept();
        BeanUtil.copyProperties(pageQry, sysDeptDO);
        PageResponse<SysDept> pageResponse = sysDeptGateway.queryPage(sysDeptDO);
        List<SysDept> sysDeptList = pageResponse.getData();
        List<SysDeptCO> sysDeptCOList = sysDeptList.stream().map(sysDept -> {
            SysDeptCO sysDeptCO = new SysDeptCO();
            BeanUtil.copyProperties(sysDept, sysDeptCO);
            return sysDeptCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysDeptCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysDeptAddCommand command) {
        SysDept sysDept = new SysDept();
        BeanUtil.copyProperties(command, sysDept);
        this.sysDeptGateway.insert(sysDept);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysDeptEditCommand command) {
        SysDept sysDept = new SysDept();
        BeanUtil.copyProperties(command, sysDept);
        this.sysDeptGateway.update(sysDept);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysDeptGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
