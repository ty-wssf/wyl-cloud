package com.wyl.dict.gatewayimpl.database.dataobject;

import lombok.Data;

/**
 * 字典类型表
 *
 * @TableName sys_dict_type
 */
@Data
public class SysDictTypeDO extends BaseDO {
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

    private static final long serialVersionUID = 1L;
}