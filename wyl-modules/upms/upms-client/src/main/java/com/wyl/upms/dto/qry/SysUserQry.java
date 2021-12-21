package com.wyl.upms.dto.qry;

import lombok.Data;

import java.util.Date;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息表(SysUser)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:56
 */
@ApiModel("用户信息表查询模型")
@Data
public class SysUserQry extends Query {

    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID", position = 1)
    private Long deptId;
    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户账号", position = 2)
    private String userName;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", position = 3)
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    @ApiModelProperty(value = "用户类型（00系统用户）", position = 4)
    private String userType;
    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "用户邮箱", position = 5)
    private String email;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", position = 6)
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    @ApiModelProperty(value = "用户性别（0男 1女 2未知）", position = 7)
    private String sex;
    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", position = 8)
    private String avatar;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", position = 9)
    private String password;
    /**
     * 帐号状态（0正常 1停用）
     */
    @ApiModelProperty(value = "帐号状态（0正常 1停用）", position = 10)
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", position = 11)
    private String delFlag;
    /**
     * 最后登录IP
     */
    @ApiModelProperty(value = "最后登录IP", position = 12)
    private String loginIp;

}
