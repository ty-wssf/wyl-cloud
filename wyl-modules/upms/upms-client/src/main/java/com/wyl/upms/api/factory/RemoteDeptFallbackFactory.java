package com.wyl.upms.api.factory;

import cn.wyl.common.core.dto.MultiResponse;
import com.wyl.upms.api.RemoteDeptService;
import com.wyl.upms.dto.clientobject.SysDeptTreeCO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.http.HttpStatus;

/**
 * @author wyl
 * @since 2021-12-23 15:27:42
 */
@Slf4j
public class RemoteDeptFallbackFactory implements FallbackFactory<RemoteDeptService> {

    @Override
    public RemoteDeptService create(Throwable cause) {
        log.error("部门服务调用失败:{}", cause.getMessage());
        return new RemoteDeptService() {
            @Override
            public MultiResponse<SysDeptTreeCO> treeList() {
                return MultiResponse.buildFailure(String.valueOf(HttpStatus.BAD_REQUEST.value()), cause.getMessage());
            }
        };
    }

}
