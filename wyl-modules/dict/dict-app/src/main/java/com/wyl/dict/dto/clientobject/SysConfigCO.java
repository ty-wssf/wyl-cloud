package com.wyl.dict.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;
import java.util.Date;
import java.io.Serializable;

/**
 * 参数配置表(SysConfig)客户端对象
 *
 * @author wyl
 * @since 2021-12-17 16:08:50
 */
@Data
public class SysConfigCO implements Serializable {
    private static final long serialVersionUID = 986001835982723199L;
    
    /**
    * 参数主键
    */    @Excel(name = "参数主键")
    private Long configId;
    /**
    * 参数名称
    */    @Excel(name = "参数名称")
    private String configName;
    /**
    * 参数键名
    */    @Excel(name = "参数键名")
    private String configKey;
    /**
    * 参数键值
    */    @Excel(name = "参数键值")
    private String configValue;
    /**
    * 系统内置（1是 0否）
    */    @Excel(name = "系统内置（1是 0否）")
    private String configType;
    /**
    * 创建者
    */    @Excel(name = "创建者")
    private String createBy;
    /**
    * 创建时间
    */    @Excel(name = "创建时间")
    private Date createTime;
    /**
    * 更新者
    */    @Excel(name = "更新者")
    private String updateBy;
    /**
    * 更新时间
    */    @Excel(name = "更新时间")
    private Date updateTime;
    /**
    * 备注
    */    @Excel(name = "备注")
    private String remark;

}
