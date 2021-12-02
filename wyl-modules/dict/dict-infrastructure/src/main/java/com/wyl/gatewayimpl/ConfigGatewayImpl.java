package com.wyl.gatewayimpl;

import com.alibaba.cola.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wyl.domain.gateway.ConfigGateway;
import com.wyl.gatewayimpl.database.SysConfigMapper;
import com.wyl.gatewayimpl.database.dataobject.SysConfig;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 配置项
 *
 * @author wyl
 * @since 2021-11-22 17:40:15
 */
@Component
public class ConfigGatewayImpl implements ConfigGateway {

    @Resource
    private SysConfigMapper configMapper;

    @Override
    public PageResponse<SysConfig> pageSelectConfigList(SysConfig sysConfig) {
        PageHelper.startPage(sysConfig.getPageIndex(), sysConfig.getPageSize());
        List<SysConfig> configList = configMapper.selectAllBySelective(sysConfig);
        PageInfo<SysConfig> pageInfo = new PageInfo<SysConfig>(configList);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    @Override
    public SysConfig selectByPrimaryKey(Long id) {
        return configMapper.selectByPrimaryKey(id);
    }

    @Override
    public SysConfig selectOneBySelective(SysConfig sysConfig) {
        return configMapper.selectOneBySelective(sysConfig);
    }

    @Override
    public void insert(SysConfig sysConfig) {
        configMapper.insert(sysConfig);
    }

    @Override
    public void updateByPrimaryKeySelective(SysConfig sysConfig) {
        configMapper.updateByPrimaryKeySelective(sysConfig);
    }

    @Override
    public void deleteByPrimaryKey(Long id) {
        configMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void batchDeleteByPrimaryKey(Long[] configIds) {
        Arrays.asList(configIds).stream().forEach(configId -> configMapper.deleteByPrimaryKey(configId));
    }

}
