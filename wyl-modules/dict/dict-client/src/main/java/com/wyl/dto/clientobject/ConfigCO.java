package com.wyl.dto.clientobject;

import lombok.Data;

import java.io.Serializable;

/**
 * @author wyl
 * @since 2021-11-22 17:53:11
 */
@Data
public class ConfigCO implements Serializable {

    /**
     * 参数主键
     */
    private Long configId;

    /**
     * 参数名称
     */
    private String configName;

    /**
     * 参数键名
     */
    private String configKey;

    /**
     * 参数键值
     */
    private String configValue;

    /**
     * 系统内置（1是 0否）
     */
    private String configType;

}
