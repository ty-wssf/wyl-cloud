package com.wyl.upms.dto.qry;

import lombok.Data;

import java.util.Date;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 岗位信息表(SysPost)查询对象
 *
 * @author wyl
 * @since 2021-12-21 09:47:52
 */
@ApiModel("岗位信息表查询模型")
@Data
public class SysPostQry extends Query {

    /**
     * 岗位编码
     */
    @ApiModelProperty(value = "岗位编码", position = 1)
    private String postCode;
    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称", position = 2)
    private String postName;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", position = 3)
    private Integer postSort;
    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value = "状态（0正常 1停用）", position = 4)
    private String status;

}
