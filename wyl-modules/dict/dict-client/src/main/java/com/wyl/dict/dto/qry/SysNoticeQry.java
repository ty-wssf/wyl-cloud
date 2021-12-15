package com.wyl.dict.dto.qry;

import cn.wyl.common.core.dto.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 通知公告表(SysNotice)查询对象
 *
 * @author wyl
 * @since 2021-12-15 09:06:41
 */
@ApiModel("通知公告表查询模型")
@Data
public class SysNoticeQry extends Query {

    /**
     * 公告标题
     */
    @ApiModelProperty(value = "公告标题", position = 1)
    private String noticeTitle;
    /**
     * 公告类型（1通知 2公告）
     */
    @ApiModelProperty(value = "公告类型（1通知 2公告）", position = 2)
    private String noticeType;
    /**
     * 公告内容
     */
    @ApiModelProperty(value = "公告内容", position = 3)
    private String noticeContent;
    /**
     * 公告状态（0正常 1关闭）
     */
    @ApiModelProperty(value = "公告状态（0正常 1关闭）", position = 4)
    private String status;

}