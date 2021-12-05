package com.wyl.dict.service;

import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.dict.dto.ConfigAddCmd;
import com.wyl.dict.dto.ConfigEditCmd;
import com.wyl.dict.dto.ConfigPageQry;
import com.wyl.dict.dto.clientobject.ConfigCO;

/**
 * @author wyl
 * @since 2021-11-22 17:47:29
 */
public interface IConfigService {

    PageResponse<ConfigCO> pageSelectConfigList(ConfigPageQry sysConfig);

    SingleResponse<ConfigCO> getConfigInfo(Long configId);

    Response addConfig(ConfigAddCmd configAddCmd);

    Response editConfig(ConfigEditCmd configAddCmd);

    Response removeConfig(Long[] configIds);

    SingleResponse<String> getConfigValueByKey(String configKey);

}
