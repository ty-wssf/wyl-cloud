package com.wyl.dict.domain.gateway;

import cn.wyl.common.core.dto.PageResponse;
import com.wyl.dict.gatewayimpl.database.dataobject.SysConfig;

import java.util.List;

/**
 * 配置项
 *
 * @author wyl
 * @since 2021-11-22 17:39:21
 */
public interface ConfigGateway {

    PageResponse<SysConfig> selectPageBySelective(SysConfig record);

    List<SysConfig> selectAllBySelective(SysConfig record);

    SysConfig selectByPrimaryKey(Long id);

    SysConfig selectOneBySelective(SysConfig record);

    void insert(SysConfig record);

    void updateByPrimaryKeySelective(SysConfig record);

    void deleteByPrimaryKey(Long id);

    void batchDeleteByPrimaryKey(Long[] configIds);

}
