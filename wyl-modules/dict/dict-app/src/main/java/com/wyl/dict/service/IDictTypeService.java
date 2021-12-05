package com.wyl.dict.service;

import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.dict.dto.clientobject.DictTypeCO;

/**
 * @author wyl
 * @since 2021-11-22 14:26:13
 */
public interface IDictTypeService {

    SingleResponse<DictTypeCO> selectDictTypeById(Long dictId);

}
