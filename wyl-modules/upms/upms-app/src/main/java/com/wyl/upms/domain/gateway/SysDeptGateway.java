package com.wyl.upms.domain.gateway;

import com.wyl.upms.gatewayimpl.database.dataobject.SysDept;
import cn.wyl.common.core.dto.PageResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门表(SysDept)表网关接口
 *
 * @author wyl
 * @since 2021-12-20 16:10:11
 */
public interface SysDeptGateway {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysDept queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDept 实例对象
     * @return 对象列表
     */
    List<SysDept> queryAll(SysDept sysDept);

    /**
     * 查询单条数据
     *
     * @param sysDept 实例对象
     * @return
     */
    SysDept queryOne(SysDept sysDept);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDept 实例对象
     * @return 对象列表
     */
    PageResponse<SysDept> queryPage(SysDept sysDept);

    /**
     * 新增数据
     *
     * @param sysDept 实例对象
     * @return 影响行数
     */
    void insert(SysDept sysDept);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDept> 实例对象列表
     * @return 影响行数
     */
    void insertBatch(@Param("entities") List<SysDept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDept> 实例对象列表
     * @return 影响行数
     */
    void insertOrUpdateBatch(@Param("entities") List<SysDept> entities);

    /**
     * 修改数据
     *
     * @param sysDept 实例对象
     * @return 影响行数
     */
    void update(SysDept sysDept);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    void deleteByPrimaryKey(Long primaryKey);

}

