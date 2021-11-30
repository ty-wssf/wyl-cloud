package com.wyl.domain.gateway;

import com.alibaba.cola.dto.PageResponse;
import com.alibaba.cola.dto.Response;
import com.wyl.gatewayimpl.database.dataobject.SysConfig;

/**
 * 配置项
 *
 * @author wyl
 * @since 2021-11-22 17:39:21
 */
public interface ConfigGateway {

    /**
     * 根据条件分页查询字典类型
     *
     * @param sysConfig 字典类型信息
     * @return 字典类型集合信息
     */
    PageResponse<SysConfig> pageSelectConfigList(SysConfig sysConfig);

    /**
     * 根据主键查询参数配置信息
     *
     * @param id
     * @return
     */
    SysConfig selectByPrimaryKey(Long id);

    /**
     * 新增参数配置
     */
    void insert(SysConfig sysConfig);

    /**
     * 编辑参数配置
     */
    void updateByPrimaryKeySelective(SysConfig sysConfig);

    /**
     * 根据主键删除配置信息
     *
     * @param id
     * @return
     */
    void deleteByPrimaryKey(Long id);

    /**
     * 批量删除
     *
     * @param configIds
     */
    void batchDeleteByPrimaryKey(Long[] configIds);

}
