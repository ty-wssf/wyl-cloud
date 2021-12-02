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
    
    PageResponse<SysConfig> pageSelectConfigList(SysConfig sysConfig);

    SysConfig selectByPrimaryKey(Long id);

    SysConfig selectOneBySelective(SysConfig record);

    void insert(SysConfig sysConfig);

    void updateByPrimaryKeySelective(SysConfig sysConfig);

    void deleteByPrimaryKey(Long id);

    void batchDeleteByPrimaryKey(Long[] configIds);

}
