package com.wyl.dict.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import cn.wyl.common.core.dto.MultiResponse;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictData;
import com.wyl.dict.service.IDictDataService;
import com.wyl.dict.domain.gateway.DictDataGateway;
import com.wyl.dict.dto.clientobject.DictDataCO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 字典数据
 *
 * @author wyl
 * @since 2021-11-26 14:56:34
 */
@CatchAndLog
@Service
public class DictDataServiceImpl implements IDictDataService {

    @Autowired
    private DictDataGateway dictDataGateway;

    @Override
    public MultiResponse<DictDataCO> selectDictDataByType(String dictType) {
        List<SysDictData> dictDataList = dictDataGateway.selectDictDataByType(dictType);
        List<DictDataCO> dictDataCOList = dictDataList.stream().map(sysDictData -> {
            DictDataCO dictDataCO = new DictDataCO();
            BeanUtils.copyProperties(sysDictData, dictDataCO);
            return dictDataCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(dictDataCOList);
    }

}
