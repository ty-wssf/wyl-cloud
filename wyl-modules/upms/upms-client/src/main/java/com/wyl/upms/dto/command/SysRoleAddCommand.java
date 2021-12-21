package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 角色信息表(SysRole)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:54
 */
@ApiModel("新增角色信息表模型")
@Data
public class SysRoleAddCommand extends Command {

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称", position = 2)
    @NotBlank(message = "角色名称不能为空")
    @Size(max = 30, message = "角色名称长度不能超过{max}个字符")
    private String roleName;
    /**
     * 角色权限字符串
     */
    @ApiModelProperty(value = "角色权限字符串", position = 3)
    @NotBlank(message = "角色权限字符串不能为空")
    @Size(max = 100, message = "角色权限字符串长度不能超过{max}个字符")
    private String roleKey;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", position = 4)
    @NotBlank(message = "显示顺序不能为空")
    private Integer roleSort;
    /**
     * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）
     */
    @ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）", position = 5)
    @Size(max = 1, message = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）长度不能超过{max}个字符")
    private String dataScope;
    /**
     * 菜单树选择项是否关联显示
     */
    @ApiModelProperty(value = "菜单树选择项是否关联显示", position = 6)
    @Size(max = 1, message = "菜单树选择项是否关联显示长度不能超过{max}个字符")
    private Integer menuCheckStrictly;
    /**
     * 部门树选择项是否关联显示
     */
    @ApiModelProperty(value = "部门树选择项是否关联显示", position = 7)
    @Size(max = 1, message = "部门树选择项是否关联显示长度不能超过{max}个字符")
    private Integer deptCheckStrictly;
    /**
     * 角色状态（0正常 1停用）
     */
    @ApiModelProperty(value = "角色状态（0正常 1停用）", position = 8)
    @NotBlank(message = "角色状态（0正常 1停用）不能为空")
    @Size(max = 1, message = "角色状态（0正常 1停用）长度不能超过{max}个字符")
    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @ApiModelProperty(value = "删除标志（0代表存在 2代表删除）", position = 9)
    @Size(max = 1, message = "删除标志（0代表存在 2代表删除）长度不能超过{max}个字符")
    private String delFlag;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", position = 10)
    @Size(max = 64, message = "创建者长度不能超过{max}个字符")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", position = 11)
    private Date createTime;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", position = 12)
    @Size(max = 64, message = "更新者长度不能超过{max}个字符")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", position = 13)
    private Date updateTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", position = 14)
    @Size(max = 640, message = "备注长度不能超过{max}个字符")
    private String remark;

}
