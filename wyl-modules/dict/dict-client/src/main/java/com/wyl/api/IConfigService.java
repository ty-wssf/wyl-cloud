package com.wyl.api;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.wyl.dto.ConfigAddCmd;
import com.wyl.dto.ConfigEditCmd;
import com.wyl.dto.ConfigPageQry;
import com.wyl.dto.clientobject.ConfigCO;

/**
 * @author wyl
 * @since 2021-11-22 17:47:29
 */
public interface IConfigService {

    /**
     * 查询参数配置列表
     */
    PageResponse<ConfigCO> pageSelectConfigList(ConfigPageQry sysConfig);

    /**
     * 新增参数配置
     */
    Response addConfig(ConfigAddCmd configAddCmd);

    /**
     * 新增参数配置
     */
    Response editConfig(ConfigEditCmd configAddCmd);

}
