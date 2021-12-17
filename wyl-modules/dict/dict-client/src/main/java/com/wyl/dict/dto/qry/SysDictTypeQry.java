package com.wyl.dict.dto.qry;

import lombok.Data;

import java.util.Date;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 字典类型表(SysDictType)查询对象
 *
 * @author wyl
 * @since 2021-12-17 21:10:58
 */
@ApiModel("字典类型表查询模型")
@Data
public class SysDictTypeQry extends Query {

    /**
     * 字典名称
     */
    @ApiModelProperty(value = "字典名称", position = 1)
    private String dictName;
    /**
     * 字典类型
     */
    @ApiModelProperty(value = "字典类型", position = 2)
    private String dictType;
    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value = "状态（0正常 1停用）", position = 3)
    private String status;

}
