package com.wyl.dict.gatewayimpl.convertor;

import com.wyl.dict.domain.model.SysDictData;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictDataDO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class DictDataConvertor {

    public static SysDictDataDO toDataObject(SysDictData dictData) {
        SysDictDataDO dictDataDO = new SysDictDataDO();
        BeanUtils.copyProperties(dictData, dictDataDO);
        return dictDataDO;
    }

    public static SysDictData toDomainObject(SysDictDataDO dictDataDO) {
        SysDictData dictData = new SysDictData();
        BeanUtils.copyProperties(dictDataDO, dictData);
        return dictData;
    }

    public static List<SysDictData> toDomainObject(List<SysDictDataDO> dictDataDOList) {
        return dictDataDOList.stream().map(sysDictDataDO -> toDomainObject(sysDictDataDO)).collect(Collectors.toList());
    }

}
