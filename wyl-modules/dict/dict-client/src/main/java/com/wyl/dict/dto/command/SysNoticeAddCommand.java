package com.wyl.dict.dto.command;

import cn.wyl.common.core.dto.Command;
import lombok.Data;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 通知公告表(SysNotice)查询对象
 *
 * @author wyl
 * @since 2021-12-15 09:06:44
 */
@ApiModel("新增通知公告表模型")
@Data
public class SysNoticeAddCommand extends Command {
    
    /**
    * 公告标题
    */    @ApiModelProperty(value = "公告标题", position = 2)
    private String noticeTitle;
    /**
    * 公告类型（1通知 2公告）
    */    @ApiModelProperty(value = "公告类型（1通知 2公告）", position = 3)
    private String noticeType;
    /**
    * 公告内容
    */    @ApiModelProperty(value = "公告内容", position = 4)
    private String noticeContent;
    /**
    * 公告状态（0正常 1关闭）
    */    @ApiModelProperty(value = "公告状态（0正常 1关闭）", position = 5)
    private String status;
    /**
    * 创建者
    */    @ApiModelProperty(value = "创建者", position = 6)
    private String createBy;
    /**
    * 创建时间
    */    @ApiModelProperty(value = "创建时间", position = 7)
    private Date createTime;
    /**
    * 更新者
    */    @ApiModelProperty(value = "更新者", position = 8)
    private String updateBy;
    /**
    * 更新时间
    */    @ApiModelProperty(value = "更新时间", position = 9)
    private Date updateTime;
    /**
    * 备注
    */    @ApiModelProperty(value = "备注", position = 10)
    private String remark;

}