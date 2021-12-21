package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户信息表(SysUser)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:56
 */
@ApiModel("编辑用户信息表模型")
@Data
public class SysUserEditCommand extends SysUserAddCommand {

    /**
     * 用户ID
     */
    @ApiModelProperty(position = 1, value = "用户ID", hidden = true)
    private Long userId;

}
