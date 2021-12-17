package com.wyl.dict.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典数据表(SysDictData)查询对象
 *
 * @author wyl
 * @since 2021-12-17 21:35:33
 */
@ApiModel("编辑字典数据表模型")
@Data
public class SysDictDataEditCommand extends SysDictDataAddCommand {

    /**
     * 字典编码
     */
    @ApiModelProperty(position = 1, value = "字典编码", hidden = true)
    private Long dictCode;

}
