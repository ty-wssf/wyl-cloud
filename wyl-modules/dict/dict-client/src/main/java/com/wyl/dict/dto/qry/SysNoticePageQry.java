package com.wyl.dict.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 通知公告表(SysNotice)查询对象
 *
 * @author wyl
 * @since 2021-12-15 09:06:44
 */
@ApiModel("通知公告表分页查询模型")
@Data
public class SysNoticePageQry extends SysNoticeQry {

    private PageQuery pageQuery;

}