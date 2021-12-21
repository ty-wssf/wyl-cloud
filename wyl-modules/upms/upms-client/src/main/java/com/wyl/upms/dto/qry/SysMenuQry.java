package com.wyl.upms.dto.qry;

import lombok.Data;

import java.util.Date;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单权限表(SysMenu)查询对象
 *
 * @author wyl
 * @since 2021-12-21 13:22:09
 */
@ApiModel("菜单权限表查询模型")
@Data
public class SysMenuQry extends Query {

    /**
     * 菜单名称
     */
    @ApiModelProperty(value = "菜单名称", position = 1)
    private String menuName;
    /**
     * 父菜单ID
     */
    @ApiModelProperty(value = "父菜单ID", position = 2)
    private Long parentId;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", position = 3)
    private Integer orderNum;
    /**
     * 路由地址
     */
    @ApiModelProperty(value = "路由地址", position = 4)
    private String path;
    /**
     * 组件路径
     */
    @ApiModelProperty(value = "组件路径", position = 5)
    private String component;
    /**
     * 路由参数
     */
    @ApiModelProperty(value = "路由参数", position = 6)
    private String query;
    /**
     * 是否为外链（0是 1否）
     */
    @ApiModelProperty(value = "是否为外链（0是 1否）", position = 7)
    private Integer isFrame;
    /**
     * 是否缓存（0缓存 1不缓存）
     */
    @ApiModelProperty(value = "是否缓存（0缓存 1不缓存）", position = 8)
    private Integer isCache;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @ApiModelProperty(value = "菜单类型（M目录 C菜单 F按钮）", position = 9)
    private String menuType;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    @ApiModelProperty(value = "菜单状态（0显示 1隐藏）", position = 10)
    private String visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    @ApiModelProperty(value = "菜单状态（0正常 1停用）", position = 11)
    private String status;
    /**
     * 权限标识
     */
    @ApiModelProperty(value = "权限标识", position = 12)
    private String perms;
    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标", position = 13)
    private String icon;

}
