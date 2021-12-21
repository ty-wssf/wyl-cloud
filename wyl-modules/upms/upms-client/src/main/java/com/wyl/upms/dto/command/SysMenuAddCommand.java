package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 菜单权限表(SysMenu)查询对象
 *
 * @author wyl
 * @since 2021-12-21 13:22:09
 */
@ApiModel("新增菜单权限表模型")
@Data
public class SysMenuAddCommand extends Command {

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称", position = 2)
    @NotBlank(message = "菜单名称不能为空")
    @Size(max = 64, message = "菜单名称长度不能超过{max}个字符")
    private String menuName;
    /**
     * 父菜单ID
     */
    @ApiModelProperty(value = "父菜单ID", position = 3)
    private Long parentId;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", position = 4)
    private Integer orderNum;
    /**
     * 路由地址
     */
    @ApiModelProperty(value = "路由地址", position = 5)
    @Size(max = 200, message = "路由地址长度不能超过{max}个字符")
    private String path;
    /**
     * 组件路径
     */
    @ApiModelProperty(value = "组件路径", position = 6)
    @Size(max = 255, message = "组件路径长度不能超过{max}个字符")
    private String component;
    /**
     * 路由参数
     */
    @ApiModelProperty(value = "路由参数", position = 7)
    @Size(max = 255, message = "路由参数长度不能超过{max}个字符")
    private String query;
    /**
     * 是否为外链（0是 1否）
     */
    @ApiModelProperty(value = "是否为外链（0是 1否）", position = 8)
    private Integer isFrame;
    /**
     * 是否缓存（0缓存 1不缓存）
     */
    @ApiModelProperty(value = "是否缓存（0缓存 1不缓存）", position = 9)
    private Integer isCache;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @ApiModelProperty(value = "菜单类型（M目录 C菜单 F按钮）", position = 10)
    @Size(max = 1, message = "菜单类型（M目录 C菜单 F按钮）长度不能超过{max}个字符")
    private String menuType;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    @ApiModelProperty(value = "菜单状态（0显示 1隐藏）", position = 11)
    @Size(max = 1, message = "菜单状态（0显示 1隐藏）长度不能超过{max}个字符")
    private String visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    @ApiModelProperty(value = "菜单状态（0正常 1停用）", position = 12)
    @Size(max = 1, message = "菜单状态（0正常 1停用）长度不能超过{max}个字符")
    private String status;
    /**
     * 权限标识
     */
    @ApiModelProperty(value = "权限标识", position = 13)
    @Size(max = 100, message = "权限标识长度不能超过{max}个字符")
    private String perms;
    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标", position = 14)
    @Size(max = 100, message = "菜单图标长度不能超过{max}个字符")
    private String icon;
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
