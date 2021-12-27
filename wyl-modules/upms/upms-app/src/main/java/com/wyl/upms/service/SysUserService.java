package com.wyl.upms.service;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import com.wyl.upms.dto.clientobject.SysUserCO;
import com.wyl.upms.dto.command.SysUserAddCommand;
import com.wyl.upms.dto.command.SysUserEditCommand;
import com.wyl.upms.dto.qry.SysUserPageQry;
import com.wyl.upms.dto.qry.SysUserQry;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUser;

import javax.validation.Valid;

/**
 * 用户信息表(SysUser)表服务接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:49
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 响应对象
     */
    SingleResponse<SysUserCO> queryByPrimaryKey(Long primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param qry 实例对象
     * @return 对象列表
     */
    MultiResponse<SysUserCO> queryAll(SysUserQry qry);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param pageQry 实例对象
     * @return 对象列表
     */
    PageResponse<SysUserCO> queryPage(SysUserPageQry pageQry);

    /**
     * 新增数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response insert(@Valid SysUserAddCommand command);

    /**
     * 修改数据
     *
     * @param command 实例对象
     * @return 是否成功
     */
    Response update(SysUserEditCommand command);

    /**
     * 通过主键删除数据
     *
     * @param primaryKeys 主键
     * @return 是否成功
     */
    Response deleteByPrimaryKeys(Long[] primaryKeys);

    /**
     * 校验用户名称是否唯一
     *
     * @param userName 用户名称
     * @return 结果
     */
    SingleResponse<Boolean> checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     *
     * @param phone 手机号码
     * @return 结果
     */
    SingleResponse<Boolean> checkPhoneUnique(String phone);

    /**
     * 校验email是否唯一
     *
     * @param email 邮件
     * @return 结果
     */
    SingleResponse<Boolean> checkEmailUnique(String email);

    /**
     * 校验手机号码是否唯一
     *
     * @param sysUser 用户信息
     * @return
     */
    SingleResponse<Boolean> checkPhoneUnique(SysUser sysUser);

    /**
     * 校验email是否唯一
     *
     * @param sysUser 用户信息
     * @return
     */
    SingleResponse<Boolean> checkEmailUnique(SysUser sysUser);

    /**
     * 新增用户信息
     *
     * @param user 用户信息
     * @return 结果
     */
    void insertUser(SysUser user);

    /**
     * 校验用户是否允许操作
     *
     * @param user 用户信息
     */
    void checkUserAllowed(SysUser user);

    /**
     * 重置用户密码
     *
     * @param user 用户信息
     */
    Response resetPwd(SysUser user);

}
