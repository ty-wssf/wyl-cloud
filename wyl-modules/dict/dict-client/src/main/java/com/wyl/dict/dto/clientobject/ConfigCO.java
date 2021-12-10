package com.wyl.dict.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import cn.wyl.common.core.utils.poi.Excel.ColumnType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wyl
 * @since 2021-11-22 17:53:11
 */
@Data
public class ConfigCO implements Serializable {

    /**
     * 参数主键
     */
    @Excel(name = "参数主键", cellType = ColumnType.NUMERIC)
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

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

}
