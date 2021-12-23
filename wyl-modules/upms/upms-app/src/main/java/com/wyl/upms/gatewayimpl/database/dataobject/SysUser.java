package com.wyl.upms.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息表(SysUser)实体类
 *
 * @author wyl
 * @since 2021-12-21 15:58:58
 */
@Data
public class SysUser extends BaseEntity {

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 用户账号
     */
    private String userName;
    /**
     * 用户昵称
     */
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    private String userType;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 手机号码
     */
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    private Integer sex;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 密码
     */
    private String password;
    /**
     * 帐号状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private Integer delFlag;
    /**
     * 最后登录IP
     */
    private String loginIp;
    /**
     * 最后登录时间
     */
    private Date loginDate;

    // 部门信息
    private SysDept dept;

}
