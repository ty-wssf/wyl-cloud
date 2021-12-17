package com.wyl.dict.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictType;
import com.wyl.dict.dto.clientobject.SysDictTypeCO;
import com.wyl.dict.dto.qry.SysDictTypeQry;
import com.wyl.dict.dto.qry.SysDictTypePageQry;
import com.wyl.dict.dto.command.SysDictTypeAddCommand;
import com.wyl.dict.dto.command.SysDictTypeEditCommand;
import com.wyl.dict.domain.gateway.SysDictTypeGateway;
import com.wyl.dict.service.SysDictTypeService;
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
 * 字典类型表(SysDictType)表服务实现类
 *
 * @author wyl
 * @since 2021-12-17 21:12:17
 */
@Validated
@Service
@CatchAndLog
public class SysDictTypeServiceImpl implements SysDictTypeService {
    @Resource
    private SysDictTypeGateway sysDictTypeGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysDictTypeCO> queryByPrimaryKey(Long primaryKey) {
        SysDictType sysDictType = this.sysDictTypeGateway.queryByPrimaryKey(primaryKey);
        SysDictTypeCO sysDictTypeCO = new SysDictTypeCO();
        BeanUtil.copyProperties(sysDictType, sysDictTypeCO);
        return SingleResponse.of(sysDictTypeCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysDictTypeCO> queryAll(SysDictTypeQry qry) {
        SysDictType sysDictTypeDO = new SysDictType();
        BeanUtil.copyProperties(qry, sysDictTypeDO);
        List<SysDictType> sysDictTypeList = sysDictTypeGateway.queryAll(sysDictTypeDO);
        List<SysDictTypeCO> sysDictTypeCOList = sysDictTypeList.stream().map(sysDictType -> {
            SysDictTypeCO sysDictTypeCO = new SysDictTypeCO();
            BeanUtil.copyProperties(sysDictType, sysDictTypeCO);
            return sysDictTypeCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysDictTypeCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysDictTypeCO> queryPage(SysDictTypePageQry pageQry) {
        SysDictType sysDictTypeDO = new SysDictType();
        BeanUtil.copyProperties(pageQry, sysDictTypeDO);
        PageResponse<SysDictType> pageResponse = sysDictTypeGateway.queryPage(sysDictTypeDO);
        List<SysDictType> sysDictTypeList = pageResponse.getData();
        List<SysDictTypeCO> sysDictTypeCOList = sysDictTypeList.stream().map(sysDictType -> {
            SysDictTypeCO sysDictTypeCO = new SysDictTypeCO();
            BeanUtil.copyProperties(sysDictType, sysDictTypeCO);
            return sysDictTypeCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysDictTypeCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysDictTypeAddCommand command) {
        SysDictType sysDictType = new SysDictType();
        BeanUtil.copyProperties(command, sysDictType);
        this.sysDictTypeGateway.insert(sysDictType);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysDictTypeEditCommand command) {
        SysDictType sysDictType = new SysDictType();
        BeanUtil.copyProperties(command, sysDictType);
        this.sysDictTypeGateway.update(sysDictType);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysDictTypeGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }
}
