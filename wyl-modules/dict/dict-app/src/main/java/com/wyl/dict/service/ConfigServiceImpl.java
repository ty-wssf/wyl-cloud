package com.wyl.dict.service;

import com.alibaba.cola.dto.PageResponse;
import com.wyl.api.IConfigService;
import com.wyl.domain.gateway.ConfigGateway;
import com.wyl.dto.SysConfigQry;
import com.wyl.dto.clientobject.ConfigCO;
import com.wyl.gatewayimpl.database.dataobject.SysConfig;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wyl
 * @since 2021-11-22 17:54:41
 */
public class ConfigServiceImpl implements IConfigService {

    @Autowired
    private ConfigGateway configGateway;

    @Override
    public PageResponse<ConfigCO> pageSelectConfigList(SysConfigQry qry) {
        SysConfig sysConfig = new SysConfig();
        BeanUtils.copyProperties(qry, sysConfig);
        PageResponse<SysConfig> pageResponse = configGateway.pageSelectConfigList(sysConfig);
        List<ConfigCO> configCOList = pageResponse.getData().stream()
                .map(config -> {
                    ConfigCO configCO = new ConfigCO();
                    BeanUtils.copyProperties(config, configCO);
                    return configCO;
                }).collect(Collectors.toList());
        return PageResponse.of(configCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

}
