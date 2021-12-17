package com.wyl.dict.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 字典数据表(SysDictData)查询对象
 *
 * @author wyl
 * @since 2021-12-17 21:35:33
 */
@ApiModel("新增字典数据表模型")
@Data
public class SysDictDataAddCommand extends Command {

    /**
     * 字典排序
     */
    @ApiModelProperty(value = "字典排序", position = 2)
    private Integer dictSort;
    /**
     * 字典标签
     */
    @ApiModelProperty(value = "字典标签", position = 3)
    @Size(max = 128, message = "字典标签长度不能超过{max}个字符")
    private String dictLabel;
    /**
     * 字典键值
     */
    @ApiModelProperty(value = "字典键值", position = 4)
    @Size(max = 128, message = "字典键值长度不能超过{max}个字符")
    private String dictValue;
    /**
     * 字典类型
     */
    @ApiModelProperty(value = "字典类型", position = 5)
    @Size(max = 128, message = "字典类型长度不能超过{max}个字符")
    private String dictType;
    /**
     * 样式属性（其他样式扩展）
     */
    @ApiModelProperty(value = "样式属性（其他样式扩展）", position = 6)
    @Size(max = 128, message = "样式属性（其他样式扩展）长度不能超过{max}个字符")
    private String cssClass;
    /**
     * 表格回显样式
     */
    @ApiModelProperty(value = "表格回显样式", position = 7)
    @Size(max = 128, message = "表格回显样式长度不能超过{max}个字符")
    private String listClass;
    /**
     * 是否默认（1是 0否）
     */
    @ApiModelProperty(value = "是否默认（1是 0否）", position = 8)
    @Size(max = 1, message = "是否默认（1是 0否）长度不能超过{max}个字符")
    private String isDefault;
    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value = "状态（0正常 1停用）", position = 9)
    @Size(max = 1, message = "状态（0正常 1停用）长度不能超过{max}个字符")
    private String status;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", position = 10)
    @Size(max = 64, message = "创建者长度不能超过{max}个字符")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", position = 11)
    private Date createTime;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", position = 12)
    @Size(max = 64, message = "更新者长度不能超过{max}个字符")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", position = 13)
    private Date updateTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", position = 14)
    @Size(max = 256, message = "备注长度不能超过{max}个字符")
    private String remark;

}
