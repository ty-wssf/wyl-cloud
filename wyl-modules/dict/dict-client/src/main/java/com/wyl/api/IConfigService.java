package com.wyl.api;

import com.alibaba.cola.dto.PageResponse;
import com.wyl.dto.SysConfigQry;
import com.wyl.dto.clientobject.ConfigCO;

/**
 * @author wyl
 * @since 2021-11-22 17:47:29
 */
public interface IConfigService {

    PageResponse<ConfigCO> pageSelectConfigList(SysConfigQry sysConfig);

}
