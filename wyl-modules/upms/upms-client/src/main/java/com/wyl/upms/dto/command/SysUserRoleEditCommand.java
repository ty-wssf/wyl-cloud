package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户和角色关联表(SysUserRole)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:58
 */
@ApiModel("编辑用户和角色关联表模型")
@Data
public class SysUserRoleEditCommand extends SysUserRoleAddCommand {

    /**
     * 用户ID
     */
    @ApiModelProperty(position = 1, value = "用户ID", hidden = true)
    private Long userId;
    /**
     * 角色ID
     */
    @ApiModelProperty(position = 2, value = "角色ID", hidden = true)
    private Long roleId;

}
