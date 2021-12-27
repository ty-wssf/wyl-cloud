package com.wyl.upms.gatewayimpl.database;

import com.wyl.upms.gatewayimpl.database.dataobject.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户信息表(SysUser)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-21 13:22:44
 */
public interface SysUserDao {

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
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUser> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUser> entities);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Long primaryKey);

    /**
     * @param userName 用户名
     * @return 实例对象
     */
    SysUser queryOneByUserName(@Param("userName") String userName);

    /**
     * @param phonenumber 手机号码
     * @return 实例对象
     */
    SysUser queryOneByPhonenumber(@Param("phonenumber") String phonenumber);

    /**
     * @param email 邮件
     * @return 实例对象
     */
    SysUser queryOneByEmail(@Param("email") String email);

}

