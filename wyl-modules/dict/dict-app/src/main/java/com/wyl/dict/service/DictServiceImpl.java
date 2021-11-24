package com.wyl.dict.service;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.cola.dto.SingleResponse;
import com.wyl.api.IDictService;
import com.wyl.domain.gateway.DictGateway;
import com.wyl.dto.clientobject.DictTypeCO;
import com.wyl.gatewayimpl.database.dataobject.SysDictType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyl
 * @since 2021-11-22 14:30:16
 */
@CatchAndLog
@Service
public class DictServiceImpl implements IDictService {

    @Autowired
    private DictGateway dictGateway;

    @Override
    public SingleResponse<DictTypeCO> selectDictTypeById(Long dictId) {
        SysDictType sysDictType = dictGateway.selectDictTypeById(dictId);
        DictTypeCO dictTypeCO = new DictTypeCO();
        BeanUtils.copyProperties(sysDictType, dictTypeCO);
        return SingleResponse.of(dictTypeCO);
    }

}
