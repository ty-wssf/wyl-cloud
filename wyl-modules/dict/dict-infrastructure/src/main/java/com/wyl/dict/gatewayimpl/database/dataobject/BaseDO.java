package com.wyl.dict.gatewayimpl.database.dataobject;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wyl
 * @since 2021-11-16 09:08:38
 */
@Data
public class BaseDO implements Serializable {

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}
