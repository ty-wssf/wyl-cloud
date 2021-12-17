package com.wyl.dict.dto.qry;

import lombok.Data;
import cn.wyl.common.core.dto.PageQuery;
import io.swagger.annotations.ApiModel;

/**
 * 参数配置表(SysConfig)查询对象
 *
 * @author wyl
 * @since 2021-12-17 16:07:57
 */
@ApiModel("参数配置表分页查询模型")
@Data
public class SysConfigPageQry extends SysConfigQry {

    private PageQuery pageQuery;

}
