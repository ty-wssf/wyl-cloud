package com.wyl.dict.domain.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author wyl
 * @since 2021-11-16 15:35:24
 */
@Data
public class SysDictType {

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

    // 字典数据
    private List<SysDictData> dictDataList;

}
