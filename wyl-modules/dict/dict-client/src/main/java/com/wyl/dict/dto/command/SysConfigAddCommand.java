package com.wyl.dict.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;

import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 参数配置表(SysConfig)查询对象
 *
 * @author wyl
 * @since 2021-12-17 16:07:57
 */
@ApiModel("新增参数配置表模型")
@Data
public class SysConfigAddCommand extends Command {

    /**
     * 参数名称
     */
    @ApiModelProperty(value = "参数名称", position = 2)
    @NotBlank(message = "参数名称不能为空")
    @Size(max = 128, message = "参数名称长度不能超过{max}个字符")
    private String configName;
    /**
     * 参数键名
     */
    @ApiModelProperty(value = "参数键名", position = 3)
    @NotBlank(message = "参数键名不能为空")
    @Size(max = 128, message = "参数键名长度不能超过{max}个字符")
    private String configKey;
    /**
     * 参数键值
     */
    @ApiModelProperty(value = "参数键值", position = 4)
    @NotBlank(message = "参数键值不能为空")
    @Size(max = 256, message = "参数键值长度不能超过{max}个字符")
    private String configValue;
    /**
     * 系统内置（1是 0否）
     */
    @ApiModelProperty(value = "系统内置（1是 0否）", position = 5)
    @Size(max = 1, message = "系统内置（1是 0否）长度不能超过{max}个字符")
    private String configType;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", position = 6)
    @Size(max = 64, message = "创建者长度不能超过{max}个字符")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", position = 7)
    private Date createTime;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", position = 8)
    @Size(max = 64, message = "更新者长度不能超过{max}个字符")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", position = 9)
    private Date updateTime;
    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", position = 10)
    @Size(max = 512, message = "备注长度不能超过{max}个字符")
    private String remark;

}
