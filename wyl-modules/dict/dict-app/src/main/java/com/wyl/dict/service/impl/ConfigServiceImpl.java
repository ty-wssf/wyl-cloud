package com.wyl.dict.service.impl;

import cn.wyl.common.core.catchlog.CatchAndLog;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.exception.Assert;
import cn.wyl.common.core.exception.ExceptionFactory;
import com.wyl.dict.gatewayimpl.database.dataobject.SysConfig;
import com.wyl.dict.service.IConfigService;
import com.wyl.dict.domain.gateway.ConfigGateway;
import com.wyl.dict.dto.ConfigAddCmd;
import com.wyl.dict.dto.ConfigEditCmd;
import com.wyl.dict.dto.ConfigPageQry;
import com.wyl.dict.dto.clientobject.ConfigCO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wyl
 * @since 2021-11-22 17:54:41
 */
@CatchAndLog
@Component
public class ConfigServiceImpl implements IConfigService {

    @Autowired
    private ConfigGateway configGateway;

    @Override
    public PageResponse<ConfigCO> pageSelectConfigList(ConfigPageQry qry) {
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

    @Override
    public SingleResponse<ConfigCO> getConfigInfo(@PathVariable Long configId) {
        SysConfig sysConfig = configGateway.selectByPrimaryKey(configId);
        ConfigCO configCO = new ConfigCO();
        BeanUtils.copyProperties(sysConfig, configCO);
        return SingleResponse.of(configCO);
    }

    @Override
    public Response addConfig(ConfigAddCmd configAddCmd) {
        SysConfig sysConfig = new SysConfig();
        BeanUtils.copyProperties(configAddCmd, sysConfig);
        configGateway.insert(sysConfig);
        return Response.buildSuccess();
    }

    @Override
    public Response editConfig(ConfigEditCmd configAddCmd) {
        SysConfig sysConfig = new SysConfig();
        BeanUtils.copyProperties(configAddCmd, sysConfig);
        configGateway.updateByPrimaryKeySelective(sysConfig);
        return Response.buildSuccess();
    }

    @Override
    public Response removeConfig(@PathVariable Long[] configIds) {
        // 校验
        for (Long configId : configIds) {
            SysConfig config = configGateway.selectByPrimaryKey(configId);
            if ("1".equals(config.getConfigType())) {
                throw ExceptionFactory.bizException(String.format("内置参数【%1$s】不能删除 ", config.getConfigKey()));
            }
        }
        configGateway.batchDeleteByPrimaryKey(configIds);
        return Response.buildSuccess();
    }

    @Override
    public SingleResponse<String> getConfigValueByKey(String configKey) {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setConfigKey(configKey);
        SysConfig retConfig = configGateway.selectOneBySelective(sysConfig);
        Assert.notNull(retConfig, "查询对象不存在");
        return SingleResponse.of(retConfig.getConfigValue());
    }

}
