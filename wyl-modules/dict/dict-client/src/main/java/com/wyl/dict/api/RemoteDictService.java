package com.wyl.dict.api;

import cn.wyl.common.core.dto.MultiResponse;
import com.wyl.dict.api.factory.RemoteDictFallbackFactory;
import com.wyl.dict.dto.clientobject.SysDictDataCO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(contextId = "remoteDictService", value = "dict", fallbackFactory = RemoteDictFallbackFactory.class)
public interface RemoteDictService {

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType
     * @return
     */
    @GetMapping(value = "/dict/data/type/{dictType}")
    MultiResponse<SysDictDataCO> selectDictDataByType(String dictType);

}
