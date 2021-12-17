package com.wyl.dict.dto.command;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 参数配置表(SysConfig)查询对象
 *
 * @author wyl
 * @since 2021-12-17 16:07:57
 */
@ApiModel("编辑参数配置表模型")
@Data
public class SysConfigEditCommand extends SysConfigAddCommand {

    /**
     * 参数主键
     */
    @ApiModelProperty(position = 1, value = "参数主键", hidden = true)
    private Long configId;

}
