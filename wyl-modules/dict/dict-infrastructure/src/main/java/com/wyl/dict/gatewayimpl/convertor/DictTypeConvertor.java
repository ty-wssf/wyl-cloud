package com.wyl.dict.gatewayimpl.convertor;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import com.wyl.dict.domain.model.SysDictData;
import com.wyl.dict.domain.model.SysDictType;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictDataDO;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictTypeDO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;


public class DictTypeConvertor {


    public static SysDictTypeDO toDataObject(SysDictType dictType) {
        SysDictTypeDO dictTypeDO = new SysDictTypeDO();
        BeanUtils.copyProperties(dictType, dictTypeDO);
        return dictTypeDO;
    }

    public static SysDictType toDomainObject(SysDictTypeDO dictTypeDO) {
        SysDictType dictType = new SysDictType();
        BeanUtils.copyProperties(dictTypeDO, dictType);
        return dictType;
    }

    public static List<SysDictType> toDomainObject(List<SysDictTypeDO> dictTypeDOList) {
        return dictTypeDOList.stream().map(sysDictTypeDO -> toDomainObject(sysDictTypeDO)).collect(Collectors.toList());
    }

}
