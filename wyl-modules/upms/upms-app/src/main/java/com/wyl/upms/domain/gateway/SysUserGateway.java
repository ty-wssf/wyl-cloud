package com.wyl.upms.domain.gateway;

import com.wyl.upms.gatewayimpl.database.dataobject.SysUser;
import cn.wyl.common.core.dto.PageResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息表(SysUser)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:46
 */
public interface SysUserGateway {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysUser queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    List<SysUser> queryAll(SysUser sysUser);

    /**
     * 查询单条数据
     *
     * @param sysUser 实例对象
     * @return
     */
    SysUser queryOne(SysUser sysUser);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    PageResponse<SysUser> queryPage(SysUser sysUser);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    void insert(SysUser sysUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    void insertBatch(@Param("entities") List<SysUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    void insertOrUpdateBatch(@Param("entities") List<SysUser> entities);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    void update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    void deleteByPrimaryKey(Long primaryKey);

    SysUser queryByUserName(String userName);

    SysUser queryByPhonenumber(String phonenumber);

    SysUser queryByEmail(String email);

}

