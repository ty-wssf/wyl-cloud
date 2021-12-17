package com.wyl.dict.dto.qry;

import lombok.Data;

import java.util.Date;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典数据表(SysDictData)查询对象
 *
 * @author wyl
 * @since 2021-12-17 21:35:33
 */
@ApiModel("字典数据表查询模型")
@Data
public class SysDictDataQry extends Query {

    /**
     * 字典排序
     */
    @ApiModelProperty(value = "字典排序", position = 1)
    private Integer dictSort;
    /**
     * 字典标签
     */
    @ApiModelProperty(value = "字典标签", position = 2)
    private String dictLabel;
    /**
     * 字典键值
     */
    @ApiModelProperty(value = "字典键值", position = 3)
    private String dictValue;
    /**
     * 字典类型
     */
    @ApiModelProperty(value = "字典类型", position = 4)
    private String dictType;
    /**
     * 样式属性（其他样式扩展）
     */
    @ApiModelProperty(value = "样式属性（其他样式扩展）", position = 5)
    private String cssClass;
    /**
     * 表格回显样式
     */
    @ApiModelProperty(value = "表格回显样式", position = 6)
    private String listClass;
    /**
     * 是否默认（1是 0否）
     */
    @ApiModelProperty(value = "是否默认（1是 0否）", position = 7)
    private String isDefault;
    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value = "状态（0正常 1停用）", position = 8)
    private String status;

}
