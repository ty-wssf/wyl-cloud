package com.wyl.dict.gatewayimpl.convertor;

import com.wyl.dict.domain.model.SysDictData;
import com.wyl.dict.domain.model.SysDictType;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictDataDO;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictTypeDO;
import org.springframework.beans.BeanUtils;

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

}
