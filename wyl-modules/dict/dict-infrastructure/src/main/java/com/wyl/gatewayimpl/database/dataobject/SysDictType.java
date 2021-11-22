package com.wyl.gatewayimpl.database.dataobject;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典类型表
 *
 * @TableName sys_dict_type
 */
@Data
public class SysDictType extends PageQuery implements Serializable {
    /**
     * 字典主键
     */
    private Long dictId;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

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

    private static final long serialVersionUID = 1L;
}