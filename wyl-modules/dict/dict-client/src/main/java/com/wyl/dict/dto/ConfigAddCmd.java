package com.wyl.dict.dto;

import cn.wyl.common.core.constraints.Dict;
import cn.wyl.common.core.dto.Command;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel("新增配置信息")
@Data
public class ConfigAddCmd extends Command {

    /**
     * 参数名称
     */
    @ApiModelProperty(value = "参数名称", required = true, example = "参数名称")
    @NotBlank(message = "参数名称不能为空")
    @Size(max = 128, message = "参数名称不能超过{max}个字符")
    private String configName;

    /**
     * 参数键名
     */
    @ApiModelProperty(value = "参数键名", required = true, example = "参数键名")
    @NotBlank(message = "参数键名不能为空")
    @Size(max = 128, message = "参数键名不能超过{max}个字符")
    private String configKey;

    /**
     * 参数键值
     */
    @ApiModelProperty(value = "参数键值", required = true, example = "参数键值")
    @NotBlank(message = "参数键值不能为空")
    @Size(max = 256, message = "参数键值长度不能超过{max}个字符")
    private String configValue;

    /**
     * 系统内置（1是 0否）
     */
    @ApiModelProperty(value = "系统内置", required = true, example = "1")
    @Dict(type = "sys_yes_no", message = "系统内置值不正确")
    private String configType;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", example = "备注")
    @Size(max = 512, message = "备注长度不能超过{max}个字符")
    private String remark;

}
