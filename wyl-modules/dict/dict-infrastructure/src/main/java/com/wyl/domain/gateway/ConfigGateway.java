package com.wyl.domain.gateway;

import com.alibaba.cola.dto.PageResponse;
import com.wyl.gatewayimpl.database.dataobject.SysConfig;

/**
 * 配置项
 *
 * @author wyl
 * @since 2021-11-22 17:39:21
 */
public interface ConfigGateway {

    /**
     * 根据条件分页查询字典类型
     *
     * @param sysConfig 字典类型信息
     * @return 字典类型集合信息
     */
    PageResponse<SysConfig> pageSelectConfigList(SysConfig sysConfig);

}
