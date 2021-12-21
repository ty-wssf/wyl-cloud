package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 用户信息表(SysUser)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:56
 */
@ApiModel("新增用户信息表模型")
@Data
public class SysUserAddCommand extends Command {

    /**
     * 部门ID
     */
    @ApiModelProperty(value = "部门ID", position = 2)
    private Long deptId;
    /**
     * 用户账号
     */
    @ApiModelProperty(value = "用户账号", position = 3)
    @NotBlank(message = "用户账号不能为空")
    @Size(max = 30, message = "用户账号长度不能超过{max}个字符")
    private String userName;
    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称", position = 4)
    @NotBlank(message = "用户昵称不能为空")
    @Size(max = 30, message = "用户昵称长度不能超过{max}个字符")
    private String nickName;
    /**
     * 用户类型（00系统用户）
     */
    @ApiModelProperty(value = "用户类型（00系统用户）", position = 5)
    @Size(max = 2, message = "用户类型（00系统用户）长度不能超过{max}个字符")
    private String userType;
    /**
     * 用户邮箱
     */
    @ApiModelProperty(value = "用户邮箱", position = 6)
    @Size(max = 64, message = "用户邮箱长度不能超过{max}个字符")
    private String email;
    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", position = 7)
    @Size(max = 11, message = "手机号码长度不能超过{max}个字符")
    private String phonenumber;
    /**
     * 用户性别（0男 1女 2未知）
     */
    @ApiModelProperty(value = "用户性别（0男 1女 2未知）", position = 8)
    @NotBlank(message = "用户性别（0男 1女 2未知）不能为空")
    @Size(max = 1, message = "用户性别（0男 1女 2未知）长度不能超过{max}个字符")
    private String sex;
    /**
     * 头像地址
     */
    @ApiModelProperty(value = "头像地址", position = 9)
    @Size(max = 100, message = "头像地址长度不能超过{max}个字符")
    private String avatar;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", position = 10)
    @Size(max = 100, message = "密码长度不能超过{max}个字符")
    private String password;
    /**
     * 帐号状态（0正常 1停用）
     */
    @ApiModelProperty(value = "帐号状态（0正常 1停用）", position = 11)
    @Size(max = 1, message = "帐号状态（0正常 1停用）长度不能超过{max}个字符")
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", position = 12)
    @Size(max = 1, message = "删除标志（0代表存在 2代表删除）长度不能超过{max}个字符")
    private String delFlag;
    /**
     * 最后登录IP
     */
    @ApiModelProperty(value = "最后登录IP", position = 13)
    @Size(max = 128, message = "最后登录IP长度不能超过{max}个字符")
    private String loginIp;
    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间", position = 14)
    private Date loginDate;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", position = 15)
    @Size(max = 64, message = "创建者长度不能超过{max}个字符")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", position = 16)
    private Date createTime;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", position = 17)
    @Size(max = 64, message = "更新者长度不能超过{max}个字符")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", position = 18)
    private Date updateTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", position = 19)
    @Size(max = 640, message = "备注长度不能超过{max}个字符")
    private String remark;

}
