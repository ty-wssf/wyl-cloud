package com.wyl.api;

import com.alibaba.cola.dto.SingleResponse;
import com.wyl.dto.clientobject.DictTypeCO;

/**
 * @author wyl
 * @since 2021-11-22 14:26:13
 */
public interface IDictTypeService {

    SingleResponse<DictTypeCO> selectDictTypeById(Long dictId);

}
