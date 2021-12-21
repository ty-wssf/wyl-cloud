package com.wyl.upms.dto.command;

import cn.wyl.common.core.dto.Command;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 岗位信息表(SysPost)查询对象
 *
 * @author wyl
 * @since 2021-12-21 09:47:53
 */
@ApiModel("新增岗位信息表模型")
@Data
public class SysPostAddCommand extends Command {

    /**
     * 岗位编码
     */
    @ApiModelProperty(value = "岗位编码", position = 2)
    @NotBlank(message = "岗位编码不能为空")
    @Size(max = 64, message = "岗位编码长度不能超过{max}个字符")
    private String postCode;
    /**
     * 岗位名称
     */
    @ApiModelProperty(value = "岗位名称", position = 3)
    @NotBlank(message = "岗位名称不能为空")
    @Size(max = 64, message = "岗位名称长度不能超过{max}个字符")
    private String postName;
    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序", position = 4)
    @NotNull(message = "显示顺序不能为空")
    private Integer postSort;
    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value = "状态（0正常 1停用）", position = 5)
    @NotBlank(message = "状态（0正常 1停用）不能为空")
    @Size(max = 1, message = "状态（0正常 1停用）长度不能超过{max}个字符")
    private String status;
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
    @Size(max = 640, message = "备注长度不能超过{max}个字符")
    private String remark;

}
