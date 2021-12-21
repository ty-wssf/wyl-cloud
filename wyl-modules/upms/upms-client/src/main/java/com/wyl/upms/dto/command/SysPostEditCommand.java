package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位信息表(SysPost)查询对象
 *
 * @author wyl
 * @since 2021-12-21 09:47:53
 */
@ApiModel("编辑岗位信息表模型")
@Data
public class SysPostEditCommand extends SysPostAddCommand {

    /**
     * 岗位ID
     */
    @ApiModelProperty(position = 1, value = "岗位ID", hidden = true)
    private Long postId;

}
