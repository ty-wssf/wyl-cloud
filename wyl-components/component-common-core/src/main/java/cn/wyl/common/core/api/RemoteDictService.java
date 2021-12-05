package cn.wyl.common.core.api;

import cn.wyl.common.core.dto.MultiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@Component
@FeignClient(contextId = "remoteDictService", name = "dict-service", fallbackFactory = RemoteDictFallbackFactory.class)
public interface RemoteDictService {

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType
     * @return
     */
    @GetMapping(value = "/dict/data/type/{dictType}")
    MultiResponse<Map<String, String>> selectDictDataByType(@PathVariable("dictType") String dictType);

}
