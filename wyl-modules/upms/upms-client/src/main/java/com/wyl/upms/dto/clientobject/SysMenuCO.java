package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 菜单权限表(SysMenu)客户端对象
 *
 * @author wyl
 * @since 2021-12-21 13:22:08
 */
@Data
public class SysMenuCO implements Serializable {
    private static final long serialVersionUID = 720706010802301475L;

    /**
     * 菜单ID
     */
    @Excel(name = "菜单ID")
    private Long menuId;
    /**
     * 菜单名称
     */
    @Excel(name = "菜单名称")
    private String menuName;
    /**
     * 父菜单ID
     */
    @Excel(name = "父菜单ID")
    private Long parentId;
    /**
     * 显示顺序
     */
    @Excel(name = "显示顺序")
    private Integer orderNum;
    /**
     * 路由地址
     */
    @Excel(name = "路由地址")
    private String path;
    /**
     * 组件路径
     */
    @Excel(name = "组件路径")
    private String component;
    /**
     * 路由参数
     */
    @Excel(name = "路由参数")
    private String query;
    /**
     * 是否为外链（0是 1否）
     */
    @Excel(name = "是否为外链（0是 1否）")
    private Integer isFrame;
    /**
     * 是否缓存（0缓存 1不缓存）
     */
    @Excel(name = "是否缓存（0缓存 1不缓存）")
    private Integer isCache;
    /**
     * 菜单类型（M目录 C菜单 F按钮）
     */
    @Excel(name = "菜单类型（M目录 C菜单 F按钮）")
    private String menuType;
    /**
     * 菜单状态（0显示 1隐藏）
     */
    @Excel(name = "菜单状态（0显示 1隐藏）")
    private String visible;
    /**
     * 菜单状态（0正常 1停用）
     */
    @Excel(name = "菜单状态（0正常 1停用）")
    private String status;
    /**
     * 权限标识
     */
    @Excel(name = "权限标识")
    private String perms;
    /**
     * 菜单图标
     */
    @Excel(name = "菜单图标")
    private String icon;
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

}
