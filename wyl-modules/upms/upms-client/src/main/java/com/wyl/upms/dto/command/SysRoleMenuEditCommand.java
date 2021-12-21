package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色和菜单关联表(SysRoleMenu)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:55
 */
@ApiModel("编辑角色和菜单关联表模型")
@Data
public class SysRoleMenuEditCommand extends SysRoleMenuAddCommand {

    /**
     * 角色ID
     */
    @ApiModelProperty(position = 1, value = "角色ID", hidden = true)
    private Long roleId;
    /**
     * 菜单ID
     */
    @ApiModelProperty(position = 2, value = "菜单ID", hidden = true)
    private Long menuId;

}
