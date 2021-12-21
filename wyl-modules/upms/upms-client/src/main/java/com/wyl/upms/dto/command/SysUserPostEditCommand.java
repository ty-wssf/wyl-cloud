package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户与岗位关联表(SysUserPost)查询对象
 *
 * @author wyl
 * @since 2021-12-21 11:50:57
 */
@ApiModel("编辑用户与岗位关联表模型")
@Data
public class SysUserPostEditCommand extends SysUserPostAddCommand {

    /**
     * 用户ID
     */
    @ApiModelProperty(position = 1, value = "用户ID", hidden = true)
    private Long userId;
    /**
     * 岗位ID
     */
    @ApiModelProperty(position = 2, value = "岗位ID", hidden = true)
    private Long postId;

}
