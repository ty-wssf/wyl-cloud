package com.wyl.dict.dto.clientobject;

import cn.wyl.common.core.utils.poi.Excel;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 通知公告表(SysNotice)客户端对象
 *
 * @author wyl
 * @since 2021-12-16 22:10:21
 */
@Data
public class SysNoticeCO implements Serializable {
    private static final long serialVersionUID = 273418694334703624L;

    /**
     * 公告ID
     */
    @Excel(name = "公告ID")
    private Integer noticeId;
    /**
     * 公告标题
     */
    @Excel(name = "公告标题")
    private String noticeTitle;
    /**
     * 公告类型（1通知 2公告）
     */
    @Excel(name = "公告类型（1通知 2公告）")
    private String noticeType;
    /**
     * 公告内容
     */
    @Excel(name = "公告内容")
    private String noticeContent;
    /**
     * 公告状态（0正常 1关闭）
     */
    @Excel(name = "公告状态（0正常 1关闭）")
    private String status;
    /**
     * 创建者
     */
    @Excel(name = "创建者")
    private String createBy;
    /**
     * 创建时间
     */
    @Excel(name = "创建时间")
    private Date createTime;
    /**
     * 更新者
     */
    @Excel(name = "更新者")
    private String updateBy;
    /**
     * 更新时间
     */
    @Excel(name = "更新时间")
    private Date updateTime;
    /**
     * 备注
     */
    @Excel(name = "备注")
    private String remark;

}
