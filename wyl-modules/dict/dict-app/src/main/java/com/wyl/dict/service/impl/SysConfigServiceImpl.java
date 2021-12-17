package com.wyl.dict.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.wyl.common.core.catchlog.CatchAndLog;
import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.exception.Assert;
import com.wyl.dict.domain.gateway.SysConfigGateway;
import com.wyl.dict.dto.clientobject.SysConfigCO;
import com.wyl.dict.dto.command.SysConfigAddCommand;
import com.wyl.dict.dto.command.SysConfigEditCommand;
import com.wyl.dict.dto.qry.SysConfigPageQry;
import com.wyl.dict.dto.qry.SysConfigQry;
import com.wyl.dict.gatewayimpl.database.dataobject.SysConfig;
import com.wyl.dict.service.SysConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 参数配置表(SysConfig)表服务实现类
 *
 * @author wyl
 * @since 2021-12-17 16:13:26
 */
@Transactional(rollbackFor = Exception.class)
@Validated
@Service
@CatchAndLog
public class SysConfigServiceImpl implements SysConfigService {
    @Resource
    private SysConfigGateway sysConfigGateway;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SingleResponse<SysConfigCO> queryByPrimaryKey(Long primaryKey) {
        SysConfig sysConfig = this.sysConfigGateway.queryByPrimaryKey(primaryKey);
        SysConfigCO sysConfigCO = new SysConfigCO();
        BeanUtil.copyProperties(sysConfig, sysConfigCO);
        return SingleResponse.of(sysConfigCO);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    @Override
    public MultiResponse<SysConfigCO> queryAll(SysConfigQry qry) {
        SysConfig sysConfigDO = new SysConfig();
        BeanUtil.copyProperties(qry, sysConfigDO);
        List<SysConfig> sysConfigList = sysConfigGateway.queryAll(sysConfigDO);
        List<SysConfigCO> sysConfigCOList = sysConfigList.stream().map(sysConfig -> {
            SysConfigCO sysConfigCO = new SysConfigCO();
            BeanUtil.copyProperties(sysConfig, sysConfigCO);
            return sysConfigCO;
        }).collect(Collectors.toList());
        return MultiResponse.of(sysConfigCOList);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysConfigCO> queryPage(SysConfigPageQry pageQry) {
        SysConfig sysConfigDO = new SysConfig();
        BeanUtil.copyProperties(pageQry, sysConfigDO);
        PageResponse<SysConfig> pageResponse = sysConfigGateway.queryPage(sysConfigDO);
        List<SysConfig> sysConfigList = pageResponse.getData();
        List<SysConfigCO> sysConfigCOList = sysConfigList.stream().map(sysConfig -> {
            SysConfigCO sysConfigCO = new SysConfigCO();
            BeanUtil.copyProperties(sysConfig, sysConfigCO);
            return sysConfigCO;
        }).collect(Collectors.toList());
        return PageResponse.of(sysConfigCOList, pageResponse.getTotalCount(), pageResponse.getPageSize(), pageResponse.getPageIndex());
    }

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response insert(@Valid SysConfigAddCommand command) {
        SysConfig sysConfig = new SysConfig();
        BeanUtil.copyProperties(command, sysConfig);
        this.sysConfigGateway.insert(sysConfig);
        return Response.buildSuccess();
    }

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    @Override
    public Response update(SysConfigEditCommand command) {
        SysConfig sysConfig = new SysConfig();
        BeanUtil.copyProperties(command, sysConfig);
        this.sysConfigGateway.update(sysConfig);
        return Response.buildSuccess();
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    @Override
    public Response deleteByPrimaryKeys(Long[] primaryKeys) {
        Arrays.stream(primaryKeys).forEach(primaryKey -> {
            SysConfig sysConfig = sysConfigGateway.queryByPrimaryKey(primaryKey);
            Assert.notNull("删除对象不存在");
            Assert.isFalse("1".equals(sysConfig.getConfigType()), String.format("内置参数【%s】不能删除 ", sysConfig.getConfigKey()));
            this.sysConfigGateway.deleteByPrimaryKey(primaryKey);
        });
        return Response.buildSuccess();
    }

    @Override
    public SingleResponse<String> getConfigValueByKey(String configKey) {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setConfigKey(configKey);
        return SingleResponse.of(sysConfigGateway.queryOne(sysConfig).getConfigValue());
    }

}
