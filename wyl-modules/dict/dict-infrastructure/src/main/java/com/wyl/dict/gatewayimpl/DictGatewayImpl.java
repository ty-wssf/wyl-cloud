package com.wyl.dict.gatewayimpl;

import com.wyl.dict.domain.gateway.DictGateway;
import com.wyl.dict.domain.model.SysDictData;
import com.wyl.dict.domain.model.SysDictType;
import com.wyl.dict.gatewayimpl.convertor.DictDataConvertor;
import com.wyl.dict.gatewayimpl.convertor.DictTypeConvertor;
import com.wyl.dict.gatewayimpl.database.SysDictDataMapper;
import com.wyl.dict.gatewayimpl.database.SysDictTypeMapper;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictDataDO;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictTypeDO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * DictGatewayImpl
 *
 * @author wyl
 * @since 2021-11-16 16:18:03
 */
@Component
@Slf4j
public class DictGatewayImpl implements DictGateway {

    @Resource
    private SysDictTypeMapper dictTypeMapper;
    @Resource
    private SysDictDataMapper dictDataMapper;

    @Override
    public void insertDictType(SysDictType dictType) {
        SysDictTypeDO dictTypeDO = DictTypeConvertor.toDataObject(dictType);
        dictTypeMapper.insert(dictTypeDO);
    }

    @Override
    public void insertDictData(SysDictData dictData) {
        SysDictDataDO dictTypeDO = DictDataConvertor.toDataObject(dictData);
        dictDataMapper.insert(dictTypeDO);
    }

    @Override
    public void updateDictType(SysDictType dictType) {
        SysDictTypeDO dictTypeDO = DictTypeConvertor.toDataObject(dictType);
        dictTypeMapper.updateByPrimaryKeySelective(dictTypeDO);
    }

    @Override
    public void updateDictData(SysDictData dictData) {
        SysDictDataDO dictTypeDO = DictDataConvertor.toDataObject(dictData);
        dictDataMapper.updateByPrimaryKeySelective(dictTypeDO);
    }

    @Override
    public void deleteDictTypeByIds(Long[] dictIds) {
        Arrays.asList(dictIds).stream().forEach(dictId -> dictTypeMapper.deleteByPrimaryKey(dictId));
    }

    @Override
    public void deleteDictDataByIds(Long[] dictCodes) {
        Arrays.asList(dictCodes).stream().forEach(dictCode -> dictDataMapper.deleteByPrimaryKey(dictCode));
    }

    @Override
    public List<SysDictType> selectDictTypeList(SysDictType dictType) {
        List<SysDictTypeDO> dictTypeDOList = dictTypeMapper.selectAll(DictTypeConvertor.toDataObject(dictType));
        List<SysDictType> dictTypeList = DictTypeConvertor.toDomainObject(dictTypeDOList);
        return dictTypeList;
    }

    @Override
    public SysDictType selectDictTypeById(Long dictId) {
        SysDictTypeDO dictTypeDO = dictTypeMapper.selectByPrimaryKey(dictId);
        return DictTypeConvertor.toDomainObject(dictTypeDO);
    }

    @Override
    public SysDictType selectDictTypeByType(String dictType) {
        SysDictTypeDO dictTypeDO = dictTypeMapper.selectOneByDictType(dictType);
        return DictTypeConvertor.toDomainObject(dictTypeDO);
    }

    @Override
    public List<SysDictData> selectDictDataByType(String dictType) {
        List<SysDictDataDO> dictDataDOList = dictDataMapper.selectByDictType(dictType);
        return DictDataConvertor.toDomainObject(dictDataDOList);
    }

}
