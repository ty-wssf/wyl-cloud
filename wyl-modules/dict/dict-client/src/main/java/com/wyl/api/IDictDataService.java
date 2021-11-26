package com.wyl.api;

import com.alibaba.cola.dto.MultiResponse;
import com.wyl.dto.clientobject.DictDataCO;

/**
 * 字典数据
 *
 * @author wyl
 * @since 2021-11-26 14:54:53
 */
public interface IDictDataService {

    MultiResponse<DictDataCO> selectDictDataByType(String dictType);

}
