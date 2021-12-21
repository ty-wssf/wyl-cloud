package com.wyl.upms.dto.qry;

import lombok.Data;

import java.util.Date;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 部门表(SysDept)查询对象
 *
 * @author wyl
 * @since 2021-12-20 16:09:04
 */
@ApiModel("部门表查询模型")
@Data
public class SysDeptQry extends Query {

    /**
     * 父部门id
     */
    @ApiModelProperty(value = "父部门id", position = 1)
    private Long parentId;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称", position = 3)
    private String deptName;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", position = 4)
    private Integer orderNum;
    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人", position = 5)
    private String leader;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话", position = 6)
    private String phone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", position = 7)
    private String email;
    /**
     * 部门状态（0正常 1停用）
     */
    @ApiModelProperty(value = "部门状态（0正常 1停用）", position = 8)
    private String status;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）", position = 9)
    private String delFlag;

}
