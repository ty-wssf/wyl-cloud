package com.wyl.upms.dto.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 部门表(SysDept)查询对象
 *
 * @author wyl
 * @since 2021-12-20 16:09:09
 */
@ApiModel("编辑部门表模型")
@Data
public class SysDeptEditCommand extends SysDeptAddCommand {

    /**
     * 部门id
     */
    @ApiModelProperty(position = 1, value = "部门id", hidden = true)
    private Long deptId;

}
