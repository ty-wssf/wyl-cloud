package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 角色和部门关联表(SysRoleDept)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:55
 */
@ApiModel("编辑角色和部门关联表模型")
@Data
public class SysRoleDeptEditCommand extends SysRoleDeptAddCommand {

    /**
     * 角色ID
     */
    @ApiModelProperty(position = 1, value = "角色ID", hidden = true)
    private Long roleId;
    /**
     * 部门ID
     */
    @ApiModelProperty(position = 2, value = "部门ID", hidden = true)
    private Long deptId;

}
