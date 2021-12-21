package com.wyl.upms.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 角色和菜单关联表(SysRoleMenu)客户端对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:55
 */
@Data
public class SysRoleMenuCO implements Serializable {
    private static final long serialVersionUID = -22057294883689267L;

    /**
     * 角色ID
     */
    @Excel(name = "角色ID")
    private Long roleId;
    /**
     * 菜单ID
     */
    @Excel(name = "菜单ID")
    private Long menuId;

}
