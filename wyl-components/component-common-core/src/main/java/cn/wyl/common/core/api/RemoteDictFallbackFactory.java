package cn.wyl.common.core.api;

import cn.wyl.common.core.dto.MultiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Slf4j
public class RemoteDictFallbackFactory implements FallbackFactory<RemoteDictService> {

    @Override
    public RemoteDictService create(Throwable cause) {
        log.error("字典服务调用失败:{}", cause.getMessage());
        return new RemoteDictService() {
            @Override
            public MultiResponse<Map<String, String>> selectDictDataByType(String dictType) {
                return MultiResponse.buildFailure(String.valueOf(HttpStatus.BAD_REQUEST.value()), cause.getMessage());
            }
        };
    }

}
