package com.wyl.dict.dto.command;

import cn.wyl.common.core.dto.Command;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 通知公告表(SysNotice)查询对象
 *
 * @author wyl
 * @since 2021-12-16 15:38:57
 */
@ApiModel("新增通知公告表模型")
@Data
public class SysNoticeAddCommand extends Command {

    /**
     * 公告标题
     */
    @ApiModelProperty(value = "公告标题", position = 2)
    @NotBlank(message = "公告标题不能为空")
    @Size(max = 64, message = "公告标题长度不能超过{max}个字符")
    private String noticeTitle;
    /**
     * 公告类型（1通知 2公告）
     */
    @ApiModelProperty(value = "公告类型（1通知 2公告）", position = 3)
    @NotBlank(message = "公告类型（1通知 2公告）不能为空")
    @Size(max = 1, message = "公告类型（1通知 2公告）长度不能超过{max}个字符")
    private String noticeType;
    /**
     * 公告内容
     */
    @ApiModelProperty(value = "公告内容", position = 4)
    @NotBlank(message = "公告内容不能为空")
    private String noticeContent;
    /**
     * 公告状态（0正常 1关闭）
     */
    @ApiModelProperty(value = "公告状态（0正常 1关闭）", position = 5)
    @Size(max = 1, message = "公告状态（0正常 1关闭）长度不能超过{max}个字符")
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
    @Size(max = 256, message = "备注长度不能超过{max}个字符")
    private String remark;

}
