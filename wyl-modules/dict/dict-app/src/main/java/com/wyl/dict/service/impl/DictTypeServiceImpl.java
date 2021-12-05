package com.wyl.dict.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictType;
import com.wyl.dict.service.IDictTypeService;
import com.wyl.dict.domain.gateway.DictTypeGateway;
import com.wyl.dict.dto.clientobject.DictTypeCO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wyl
 * @since 2021-11-22 14:30:16
 */
@CatchAndLog
@Service
public class DictTypeServiceImpl implements IDictTypeService {

    @Autowired
    private DictTypeGateway dictGateway;

    @Override
    public SingleResponse<DictTypeCO> selectDictTypeById(Long dictId) {
        SysDictType sysDictType = dictGateway.selectDictTypeById(dictId);
        DictTypeCO dictTypeCO = new DictTypeCO();
        BeanUtils.copyProperties(sysDictType, dictTypeCO);
        return SingleResponse.of(dictTypeCO);
    }

}
