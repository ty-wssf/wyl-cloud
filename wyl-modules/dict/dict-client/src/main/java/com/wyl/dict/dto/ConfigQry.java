package com.wyl.dict.dto;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Map;

@Data
public class ConfigQry extends Query {

    /**
     * 参数名称
     */
    @ApiModelProperty(value = "参数名称", example = "参数名称")
    private String configName;

    /**
     * 参数键名
     */
    @ApiModelProperty(value = "参数键名", example = "参数键名")
    private String configKey;

    /**
     * 系统内置（1是 0否）
     */
    @ApiModelProperty(value = "系统内置", example = "1")
    private String configType;

    /**
     * 请求参数
     */
    @ApiModelProperty(value = "通用参数")
    private Map<String, Object> params;

}
