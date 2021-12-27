package com.wyl.dict.gatewayimpl.database.dataobject;

import cn.wyl.common.core.web.domain.BaseEntity;
import lombok.Data;

/**
 * 字典类型表
 *
 * @TableName sys_dict_type
 */
@Data
public class SysDictType extends BaseEntity {
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
     * 字典数据类型（1字符串 2数字）
     */
    private String dataType;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

}