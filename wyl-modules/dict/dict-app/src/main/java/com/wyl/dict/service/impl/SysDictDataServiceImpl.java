package com.wyl.dict.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictData;
import com.wyl.dict.dto.clientobject.SysDictDataCO;
import com.wyl.dict.dto.qry.SysDictDataQry;
import com.wyl.dict.dto.qry.SysDictDataPageQry;
import com.wyl.dict.dto.command.SysDictDataAddCommand;
import com.wyl.dict.dto.command.SysDictDataEditCommand;
import com.wyl.dict.domain.gateway.SysDictDataGateway;
import com.wyl.dict.service.SysDictDataService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import cn.hutool.core.bean.BeanUtil;

import javax.annotation.Resource;
import java.util.List;
import java.util.Arrays;
import javax.validation.Valid;
import java.util.stream.Collectors;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;

/**
 * 字典数据表(SysDictData)表服务实现类
 *
 * @author wyl
 * @since 2021-12-17 21:35:56
 */
@Validated
@Service
@CatchAndLog
public class SysDictDataServiceImpl implements SysDictDataService {
    @Resource
    private SysDictDataGateway sysDictDataGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysDictDataCO> queryByPrimaryKey(Long primaryKey) {
        SysDictData sysDictData = this.sysDictDataGateway.queryByPrimaryKey(primaryKey);
        SysDictDataCO sysDictDataCO = new SysDictDataCO();
        BeanUtil.copyProperties(sysDictData, sysDictDataCO);
        return SingleResponse.of(sysDictDataCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysDictDataCO> queryAll(SysDictDataQry qry) {
        SysDictData sysDictDataDO = new SysDictData();
        BeanUtil.copyProperties(qry, sysDictDataDO);
        List<SysDictData> sysDictDataList = sysDictDataGateway.queryAll(sysDictDataDO);
        List<SysDictDataCO> sysDictDataCOList = sysDictDataList.stream().map(sysDictData -> {
            SysDictDataCO sysDictDataCO = new SysDictDataCO();
            BeanUtil.copyProperties(sysDictData, sysDictDataCO);
            return sysDictDataCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysDictDataCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysDictDataCO> queryPage(SysDictDataPageQry pageQry) {
        SysDictData sysDictDataDO = new SysDictData();
        BeanUtil.copyProperties(pageQry, sysDictDataDO);
        PageResponse<SysDictData> pageResponse = sysDictDataGateway.queryPage(sysDictDataDO);
        List<SysDictData> sysDictDataList = pageResponse.getData();
        List<SysDictDataCO> sysDictDataCOList = sysDictDataList.stream().map(sysDictData -> {
            SysDictDataCO sysDictDataCO = new SysDictDataCO();
            BeanUtil.copyProperties(sysDictData, sysDictDataCO);
            return sysDictDataCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysDictDataCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysDictDataAddCommand command) {
        SysDictData sysDictData = new SysDictData();
        BeanUtil.copyProperties(command, sysDictData);
        this.sysDictDataGateway.insert(sysDictData);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysDictDataEditCommand command) {
        SysDictData sysDictData = new SysDictData();
        BeanUtil.copyProperties(command, sysDictData);
        this.sysDictDataGateway.update(sysDictData);
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
        Arrays.asList(primaryKeys).stream().forEach(primaryKey -> this.sysDictDataGateway.deleteByPrimaryKey(primaryKey));
        return Response.buildSuccess();
    }

    @Override
    public MultiResponse<SysDictDataCO> queryDictDataByType(String dictType) {
        SysDictData sysDictDataDO = new SysDictData();
        sysDictDataDO.setDictType(dictType);
        List<SysDictData> sysDictDataList = sysDictDataGateway.queryAll(sysDictDataDO);
        List<SysDictDataCO> sysDictDataCOList = sysDictDataList.stream().map(sysDictData -> {
            SysDictDataCO sysDictDataCO = new SysDictDataCO();
            BeanUtil.copyProperties(sysDictData, sysDictDataCO);
            return sysDictDataCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysDictDataCOList);
    }

}
