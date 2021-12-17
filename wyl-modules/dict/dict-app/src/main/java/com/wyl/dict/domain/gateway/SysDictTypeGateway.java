package com.wyl.dict.domain.gateway;

import com.wyl.dict.gatewayimpl.database.dataobject.SysDictType;
import cn.wyl.common.core.dto.PageResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 字典类型表(SysDictType)表网关接口
 *
 * @author wyl
 * @since 2021-12-17 21:12:15
 */
public interface SysDictTypeGateway {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysDictType queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictType 实例对象
     * @return 对象列表
     */
    List<SysDictType> queryAll(SysDictType sysDictType);

    /**
     * 查询单条数据
     *
     * @param sysDictType 实例对象
     * @return
     */
    SysDictType queryOne(SysDictType sysDictType);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictType 实例对象
     * @return 对象列表
     */
    PageResponse<SysDictType> queryPage(SysDictType sysDictType);

    /**
     * 新增数据
     *
     * @param sysDictType 实例对象
     * @return 影响行数
     */
    void insert(SysDictType sysDictType);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictType> 实例对象列表
     * @return 影响行数
     */
    void insertBatch(@Param("entities") List<SysDictType> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictType> 实例对象列表
     * @return 影响行数
     */
    void insertOrUpdateBatch(@Param("entities") List<SysDictType> entities);

    /**
     * 修改数据
     *
     * @param sysDictType 实例对象
     * @return 影响行数
     */
    void update(SysDictType sysDictType);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    void deleteByPrimaryKey(Long primaryKey);

}

