package com.wyl.upms.api;

import cn.wyl.common.core.dto.MultiResponse;
import com.wyl.upms.api.factory.RemoteDeptFallbackFactory;
import com.wyl.upms.dto.clientobject.SysDeptTreeCO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 部门服务
 *
 * @author wyl
 * @since 2021-12-23 15:25:57
 */
@FeignClient(contextId = "remoteUpmsService", value = "upms-service", fallbackFactory = RemoteDeptFallbackFactory.class)
public interface RemoteDeptService {


    @GetMapping("/sysDept/tree")
    MultiResponse<SysDeptTreeCO> treeList();

}
