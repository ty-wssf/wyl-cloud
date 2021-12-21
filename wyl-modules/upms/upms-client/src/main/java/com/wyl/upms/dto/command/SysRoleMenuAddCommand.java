package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 角色和菜单关联表(SysRoleMenu)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:55
 */
@ApiModel("新增角色和菜单关联表模型")
@Data
public class SysRoleMenuAddCommand extends Command {


}
