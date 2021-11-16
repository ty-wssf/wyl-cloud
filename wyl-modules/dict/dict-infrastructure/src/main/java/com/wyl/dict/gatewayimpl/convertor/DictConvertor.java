package com.wyl.dict.gatewayimpl.convertor;

import com.wyl.dict.domain.model.SysDictData;
import com.wyl.dict.domain.model.SysDictType;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictDataDO;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictTypeDO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wyl
 * @since 2021-11-16 16:24:44
 */
public class DictConvertor {

    public static SysDictTypeDO dictTypeToDataObject(SysDictType dictType) {
        SysDictTypeDO dictTypeDO = new SysDictTypeDO();
        BeanUtils.copyProperties(dictType, dictTypeDO);
        return dictTypeDO;
    }

    public static SysDictDataDO dictDataToDataObject(SysDictData dictData) {
        SysDictDataDO dictDataDO = new SysDictDataDO();
        BeanUtils.copyProperties(dictData, dictDataDO);
        return dictDataDO;
    }

    public static SysDictType toDomainObject(SysDictTypeDO dictTypeDO, List<SysDictDataDO> dictDataDOList) {
        SysDictType dictType = new SysDictType();
        BeanUtils.copyProperties(dictTypeDO, dictType);

        List<SysDictData> dictDataList = dictDataDOList.stream().map(dictDataDO -> {
            SysDictData dictData = new SysDictData();
            BeanUtils.copyProperties(dictTypeDO, dictData);
            return dictData;
        }).collect(Collectors.toList());

        dictType.setDictDataList(dictDataList);
        return dictType;
    }

}
