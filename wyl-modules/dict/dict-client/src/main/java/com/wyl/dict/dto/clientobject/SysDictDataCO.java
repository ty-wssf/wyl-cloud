package com.wyl.dict.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 字典数据表(SysDictData)客户端对象
 *
 * @author wyl
 * @since 2021-12-17 21:35:33
 */
@Data
public class SysDictDataCO implements Serializable {
    private static final long serialVersionUID = 556815116735543696L;

    /**
     * 字典编码
     */
    @Excel(name = "字典编码")
    private Long dictCode;
    /**
     * 字典排序
     */
    @Excel(name = "字典排序")
    private Integer dictSort;
    /**
     * 字典标签
     */
    @Excel(name = "字典标签")
    private String dictLabel;
    /**
     * 字典键值
     */
    @Excel(name = "字典键值")
    private String dictValue;
    /**
     * 字典类型
     */
    @Excel(name = "字典类型")
    private String dictType;
    /**
     * 样式属性（其他样式扩展）
     */
    @Excel(name = "样式属性（其他样式扩展）")
    private String cssClass;
    /**
     * 表格回显样式
     */
    @Excel(name = "表格回显样式")
    private String listClass;
    /**
     * 是否默认（1是 0否）
     */
    @Excel(name = "是否默认（1是 0否）")
    private String isDefault;
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
