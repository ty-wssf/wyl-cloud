package com.wyl.dict.domain.gateway;

import com.wyl.dict.gatewayimpl.database.dataobject.SysConfig;
import cn.wyl.common.core.dto.PageResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 参数配置表(SysConfig)表网关接口
 *
 * @author wyl
 * @since 2021-12-17 16:35:43
 */
public interface SysConfigGateway {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysConfig queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysConfig 实例对象
     * @return 对象列表
     */
    List<SysConfig> queryAll(SysConfig sysConfig);

    /**
     * 查询单条数据
     *
     * @param sysConfig 实例对象
     * @return
     */
    SysConfig queryOne(SysConfig sysConfig);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysConfig 实例对象
     * @return 对象列表
     */
    PageResponse<SysConfig> queryPage(SysConfig sysConfig);

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 影响行数
     */
    void insert(SysConfig sysConfig);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysConfig> 实例对象列表
     * @return 影响行数
     */
    void insertBatch(@Param("entities") List<SysConfig> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysConfig> 实例对象列表
     * @return 影响行数
     */
    void insertOrUpdateBatch(@Param("entities") List<SysConfig> entities);

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 影响行数
     */
    void update(SysConfig sysConfig);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    void deleteByPrimaryKey(Long primaryKey);

}

