package com.wyl.dict.dto.qry;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 参数配置表(SysConfig)查询对象
 *
 * @author wyl
 * @since 2021-12-17 16:07:57
 */
@ApiModel("参数配置表查询模型")
@Data
public class SysConfigQry extends Query {

    /**
     * 参数名称
     */
    @ApiModelProperty(value = "参数名称", position = 1)
    private String configName;
    /**
     * 参数键名
     */
    @ApiModelProperty(value = "参数键名", position = 2)
    private String configKey;
    /**
     * 参数键值
     */
    @ApiModelProperty(value = "参数键值", position = 3)
    private String configValue;
    /**
     * 系统内置（1是 0否）
     */
    @ApiModelProperty(value = "系统内置（1是 0否）", position = 4)
    private String configType;

}
