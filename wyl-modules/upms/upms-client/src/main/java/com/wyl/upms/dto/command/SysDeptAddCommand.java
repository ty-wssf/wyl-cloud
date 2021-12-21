package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 部门表(SysDept)查询对象
 *
 * @author wyl
 * @since 2021-12-20 16:09:08
 */
@ApiModel("新增部门表模型")
@Data
public class SysDeptAddCommand extends Command {

    /**
     * 父部门id
     */
    @ApiModelProperty(value = "父部门id", position = 2)
    private Long parentId;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称", position = 4)
    @NotBlank(message = "部门名称不能为空")
    @Size(max = 30, message = "部门名称长度不能超过{max}个字符")
    private String deptName;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", position = 5)
    private Integer orderNum;
    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人", position = 6)
    @Size(max = 20, message = "负责人长度不能超过{max}个字符")
    private String leader;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话", position = 7)
    @Size(max = 11, message = "联系电话长度不能超过{max}个字符")
    private String phone;
    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", position = 8)
    @Size(max = 64, message = "邮箱长度不能超过{max}个字符")
    private String email;
    /**
     * 部门状态（0正常 1停用）
     */
    @ApiModelProperty(value = "部门状态（0正常 1停用）", position = 9)
    @Size(max = 1, message = "部门状态（0正常 1停用）长度不能超过{max}个字符")
    private String status;
    /**
     * 删除标志（0代表存在 1代表删除）
     */
    @ApiModelProperty(value = "删除标志（0代表存在 1代表删除）", position = 10)
    @Size(max = 1, message = "删除标志（0代表存在 1代表删除）长度不能超过{max}个字符")
    private String delFlag;
    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", position = 11)
    @Size(max = 64, message = "创建者长度不能超过{max}个字符")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", position = 12)
    private Date createTime;
    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", position = 13)
    @Size(max = 64, message = "更新者长度不能超过{max}个字符")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", position = 14)
    private Date updateTime;

}
