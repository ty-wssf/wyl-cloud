package com.wyl.dict.dto;

import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wyl
 * @since 2021-11-22 17:53:50
 */
@Data
public class ConfigPageQry extends ConfigQry {

    private PageQuery pageQuery;

}
