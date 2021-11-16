package com.wyl.dict.gatewayimpl;

import com.wyl.dict.domain.gateway.DictGateway;
import com.wyl.dict.domain.model.SysDictData;
import com.wyl.dict.domain.model.SysDictType;
import com.wyl.dict.gatewayimpl.convertor.DictConvertor;
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
        SysDictTypeDO dictTypeDO = DictConvertor.dictTypeToDataObject(dictType);
        dictTypeMapper.insert(dictTypeDO);
    }

    @Override
    public void updateDictType(SysDictType dictType) {
        SysDictTypeDO dictTypeDO = DictConvertor.dictTypeToDataObject(dictType);
        dictTypeMapper.updateByPrimaryKeySelective(dictTypeDO);
    }

    @Override
    public void insertDictData(SysDictData dictData) {
        SysDictDataDO dictTypeDO = DictConvertor.dictDataToDataObject(dictData);
        dictDataMapper.insert(dictTypeDO);
    }

    @Override
    public void updateDictData(SysDictData dictData) {
        SysDictDataDO dictTypeDO = DictConvertor.dictDataToDataObject(dictData);
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
        return null;
    }

    @Override
    public List<SysDictType> selectDictDataByType(String dictType) {
        List<SysDictDataDO> dictDataDOList = dictDataMapper.selectByDictType(dictType);
        SysDictTypeDO dictTypeDO = dictTypeMapper.selectOneByDictType(dictType);
        return null;
    }

    @Override
    public SysDictType selectDictTypeById(Long dictId) {
        return null;
    }

}
