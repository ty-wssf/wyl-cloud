package com.wyl.api;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.wyl.dto.ConfigAddCmd;
import com.wyl.dto.ConfigEditCmd;
import com.wyl.dto.ConfigPageQry;
import com.wyl.dto.clientobject.ConfigCO;

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
