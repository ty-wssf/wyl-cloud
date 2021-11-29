package com.wyl.dto;

import com.alibaba.cola.dto.PageQuery;
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
    private String configName;

    /**
     * 参数键名
     */
    private String configKey;

    /**
     * 系统内置（1是 0否）
     */
    private String configType;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

}
