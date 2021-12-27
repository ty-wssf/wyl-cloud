package com.wyl.upms.domain.gateway;

import cn.wyl.common.core.dto.PageResponse;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUserRole;

import java.util.List;

/**
 * 用户和角色关联表(SysUserRole)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:54
 */
public interface SysUserRoleGateway {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysUserRole queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserRole 实例对象
     * @return 对象列表
     */
    List<SysUserRole> queryAll(SysUserRole sysUserRole);

    /**
     * 查询单条数据
     *
     * @param sysUserRole 实例对象
     * @return
     */
    SysUserRole queryOne(SysUserRole sysUserRole);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserRole 实例对象
     * @return 对象列表
     */
    PageResponse<SysUserRole> queryPage(SysUserRole sysUserRole);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    void insert(SysUserRole sysUserRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserRole> 实例对象列表
     * @return 影响行数
     */
    void insertBatch(List<SysUserRole> entities);

    /**
     * 修改数据
     *
     * @param sysUserRole 实例对象
     * @return 影响行数
     */
    void update(SysUserRole sysUserRole);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    void deleteByPrimaryKey(Long primaryKey);

    /**
     * 删除用户与角色关联
     *
     * @param userId
     */
    void deleteUserRoleByUserId(Long userId);

}

