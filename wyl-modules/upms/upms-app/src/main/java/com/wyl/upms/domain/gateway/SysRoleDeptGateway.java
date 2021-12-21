package com.wyl.upms.domain.gateway;

import com.wyl.upms.gatewayimpl.database.dataobject.SysRoleDept;
import cn.wyl.common.core.dto.PageResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色和部门关联表(SysRoleDept)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:39
 */
public interface SysRoleDeptGateway {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysRoleDept queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleDept 实例对象
     * @return 对象列表
     */
    List<SysRoleDept> queryAll(SysRoleDept sysRoleDept);

    /**
     * 查询单条数据
     *
     * @param sysRoleDept 实例对象
     * @return
     */
    SysRoleDept queryOne(SysRoleDept sysRoleDept);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleDept 实例对象
     * @return 对象列表
     */
    PageResponse<SysRoleDept> queryPage(SysRoleDept sysRoleDept);

    /**
     * 新增数据
     *
     * @param sysRoleDept 实例对象
     * @return 影响行数
     */
    void insert(SysRoleDept sysRoleDept);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleDept> 实例对象列表
     * @return 影响行数
     */
    void insertBatch(@Param("entities") List<SysRoleDept> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleDept> 实例对象列表
     * @return 影响行数
     */
    void insertOrUpdateBatch(@Param("entities") List<SysRoleDept> entities);

    /**
     * 修改数据
     *
     * @param sysRoleDept 实例对象
     * @return 影响行数
     */
    void update(SysRoleDept sysRoleDept);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    void deleteByPrimaryKey(Long primaryKey);

}

