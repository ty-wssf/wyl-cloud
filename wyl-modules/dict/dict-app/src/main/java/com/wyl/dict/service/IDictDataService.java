package com.wyl.dict.service;

import cn.wyl.common.core.dto.MultiResponse;
import com.wyl.dict.dto.clientobject.DictDataCO;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 字典数据
 *
 * @author wyl
 * @since 2021-11-26 14:54:53
 */
public interface IDictDataService {

    MultiResponse<DictDataCO> selectDictDataByType(String dictType);

}
