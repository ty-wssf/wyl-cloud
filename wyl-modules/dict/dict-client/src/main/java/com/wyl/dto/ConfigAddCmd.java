package com.wyl.dto;

import com.alibaba.cola.dto.Command;
import lombok.Data;

@Data
public class ConfigAddCmd extends Command {

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
