package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 角色和部门关联表(SysRoleDept)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:54
 */
@ApiModel("新增角色和部门关联表模型")
@Data
public class SysRoleDeptAddCommand extends Command {


}
