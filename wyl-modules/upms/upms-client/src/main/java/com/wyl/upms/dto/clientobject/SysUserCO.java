package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户信息表(SysUser)客户端对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:55
 */
@Data
public class SysUserCO implements Serializable {
    private static final long serialVersionUID = -24485229116846478L;

    /**
     * 用户ID
     */
    @Excel(name = "用户ID")
    private Long userId;
    /**
     * 部门ID
     */
    @Excel(name = "部门ID")
    private Long deptId;
    /**
     * 用户账号
     */
    @Excel(name = "用户账号")
    private String userName;
    /**
     * 用户昵称
     */
    @Excel(name = "用户昵称")
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    @Excel(name = "用户类型（00系统用户）")
    private String userType;
    /**
     * 用户邮箱
     */
    @Excel(name = "用户邮箱")
    private String email;
    /**
     * 手机号码
     */
    @Excel(name = "手机号码")
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    @Excel(name = "用户性别（0男 1女 2未知）")
    private Integer sex;
    /**
     * 头像地址
     */
    @Excel(name = "头像地址")
    private String avatar;
    /**
     * 密码
     */
    @Excel(name = "密码")
    private String password;
    /**
     * 帐号状态（0正常 1停用）
     */
    @Excel(name = "帐号状态（0正常 1停用）")
    private Integer status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @Excel(name = "删除标志（0代表存在 2代表删除）")
    private Integer delFlag;
    /**
     * 最后登录IP
     */
    @Excel(name = "最后登录IP")
    private String loginIp;
    /**
     * 最后登录时间
     */
    @Excel(name = "最后登录时间")
    private Date loginDate;
    /**
     * 创建者
     */
    @Excel(name = "创建者")
    private String createBy;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    private Date createTime;
    /**
     * 更新者
     */
    @Excel(name = "更新者")
    private String updateBy;
    /**
     * 更新时间
     */
    @Excel(name = "更新时间")
    private Date updateTime;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

    // 部门信息
    private SysDeptCO dept;
    // 岗位ID
    private long[] postIds;
    // 角色ID
    private long[] roleIds;

}
