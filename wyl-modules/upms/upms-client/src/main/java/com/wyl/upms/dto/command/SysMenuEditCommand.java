package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单权限表(SysMenu)查询对象
 *
 * @author wyl
 * @since 2021-12-21 13:22:10
 */
@ApiModel("编辑菜单权限表模型")
@Data
public class SysMenuEditCommand extends SysMenuAddCommand {

    /**
     * 菜单ID
     */
    @ApiModelProperty(position = 1, value = "菜单ID", hidden = true)
    private Long menuId;

}
