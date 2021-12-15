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
 * @since 2021-12-15 09:06:46
 */
@ApiModel("编辑通知公告表模型")
@Data
public class SysNoticeEditCommand extends SysNoticeAddCommand {
    
    /**
    * 公告ID
    */    @ApiModelProperty(position = 1, value = "公告ID", hidden = true)
    private Integer noticeId;

}