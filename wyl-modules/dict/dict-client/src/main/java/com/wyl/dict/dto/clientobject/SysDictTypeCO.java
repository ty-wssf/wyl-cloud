package com.wyl.dict.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 字典类型表(SysDictType)客户端对象
 *
 * @author wyl
 * @since 2021-12-17 21:10:58
 */
@Data
public class SysDictTypeCO implements Serializable {
    private static final long serialVersionUID = -11818979095517687L;

    /**
     * 字典主键
     */
    @Excel(name = "字典主键")
    private Long dictId;
    /**
     * 字典名称
     */
    @Excel(name = "字典名称")
    private String dictName;
    /**
     * 字典类型
     */
    @Excel(name = "字典类型")
    private String dictType;
    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态（0正常 1停用）")
    private String status;
    /**
     * 创建者
     */
    @Excel(name = "创建者")
    private String createBy;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    private Date createTime;
    /**
     * 更新者
     */
    @Excel(name = "更新者")
    private String updateBy;
    /**
     * 更新时间
     */
    @Excel(name = "更新时间")
    private Date updateTime;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

}
