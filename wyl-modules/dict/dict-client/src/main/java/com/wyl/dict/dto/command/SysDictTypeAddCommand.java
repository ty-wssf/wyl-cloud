package com.wyl.dict.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 字典类型表(SysDictType)查询对象
 *
 * @author wyl
 * @since 2021-12-17 21:10:58
 */
@ApiModel("新增字典类型表模型")
@Data
public class SysDictTypeAddCommand extends Command {

    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称", position = 2)
    @Size(max = 128, message = "字典名称长度不能超过{max}个字符")
    private String dictName;
    /**
     * 字典类型
     */
    @ApiModelProperty(value = "字典类型", position = 3)
    @Size(max = 128, message = "字典类型长度不能超过{max}个字符")
    private String dictType;
    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value = "状态（0正常 1停用）", position = 4)
    @Size(max = 1, message = "状态（0正常 1停用）长度不能超过{max}个字符")
    private String status;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", position = 5)
    @Size(max = 64, message = "创建者长度不能超过{max}个字符")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", position = 6)
    private Date createTime;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", position = 7)
    @Size(max = 64, message = "更新者长度不能超过{max}个字符")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", position = 8)
    private Date updateTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", position = 9)
    @Size(max = 256, message = "备注长度不能超过{max}个字符")
    private String remark;

}
