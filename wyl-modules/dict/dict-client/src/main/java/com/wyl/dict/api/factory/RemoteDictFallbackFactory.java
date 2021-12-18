package com.wyl.dict.api.factory;

import cn.wyl.common.core.dto.MultiResponse;
import com.wyl.dict.api.RemoteDictService;
import com.wyl.dict.dto.clientobject.SysDictDataCO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;

@Slf4j
public class RemoteDictFallbackFactory implements FallbackFactory<RemoteDictService> {

    @Override
    public RemoteDictService create(Throwable cause) {
        log.error("字典服务调用失败:{}", cause.getMessage());
        return new RemoteDictService() {
            @Override
            public MultiResponse<SysDictDataCO> selectDictDataByType(String dictType) {
                return MultiResponse.buildFailure(String.valueOf(HttpStatus.BAD_REQUEST.value()), cause.getMessage());
            }
        };
    }

}
