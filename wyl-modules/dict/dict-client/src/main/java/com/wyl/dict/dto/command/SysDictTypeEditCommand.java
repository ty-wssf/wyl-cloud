package com.wyl.dict.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典类型表(SysDictType)查询对象
 *
 * @author wyl
 * @since 2021-12-17 21:10:59
 */
@ApiModel("编辑字典类型表模型")
@Data
public class SysDictTypeEditCommand extends SysDictTypeAddCommand {

    /**
     * 字典主键
     */
    @ApiModelProperty(position = 1, value = "字典主键", hidden = true)
    private Long dictId;

}
