package com.wyl.dict.dto;

import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyl
 * @since 2021-11-22 17:53:50
 */
@Data
public class ConfigPageQry extends PageQuery {

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
