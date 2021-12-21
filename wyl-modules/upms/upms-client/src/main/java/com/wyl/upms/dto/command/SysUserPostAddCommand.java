package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 用户与岗位关联表(SysUserPost)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:57
 */
@ApiModel("新增用户与岗位关联表模型")
@Data
public class SysUserPostAddCommand extends Command {


}
