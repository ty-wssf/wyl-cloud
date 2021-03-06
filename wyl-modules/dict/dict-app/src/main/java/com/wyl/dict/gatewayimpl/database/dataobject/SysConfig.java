package com.wyl.dict.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 参数配置表(SysConfig)实体类
 *
 * @author wyl
 * @since 2021-12-17 16:08:37
 */
@Data
public class SysConfig extends BaseEntity {

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
