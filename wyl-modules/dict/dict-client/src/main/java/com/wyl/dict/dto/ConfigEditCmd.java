package com.wyl.dict.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel("编辑配置信息")
@Data
public class ConfigEditCmd extends ConfigAddCmd {

    @ApiModelProperty(value = "参数主键", required = true, example = "参数主键")
    @NotBlank(message = "参数主键不能为空")
    private String configId;

}
