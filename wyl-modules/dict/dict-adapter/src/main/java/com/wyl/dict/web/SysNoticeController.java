package com.wyl.dict.web;

import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.wyl.dict.dto.clientobject.SysNoticeCO;
import com.wyl.dict.dto.command.SysNoticeAddCommand;
import com.wyl.dict.dto.command.SysNoticeEditCommand;
import com.wyl.dict.dto.qry.SysNoticePageQry;
import com.wyl.dict.dto.qry.SysNoticeQry;
import com.wyl.dict.service.SysNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 通知公告表(SysNotice)表控制层
 *
 * @author wyl
 * @since 2021-12-16 15:50:05
 */
@Api(tags = "通知公告表模块")
@RestController
@RequestMapping("sysNotice")
public class SysNoticeController {
    /**
     * 服务对象
     */
    @Resource
    private SysNoticeService sysNoticeService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysNoticeCO> pageList(SysNoticePageQry qry) {
        return this.sysNoticeService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysNoticeCO> getInfo(@ApiParam(value = "主键", required = true)
                                               @PathVariable Integer id) {
        return this.sysNoticeService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysNoticeAddCommand command) {
        return this.sysNoticeService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@Validated @RequestBody SysNoticeEditCommand command, @PathVariable Integer id) {
        command.setNoticeId(id);
        return this.sysNoticeService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Integer[] ids) {
        return this.sysNoticeService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysNoticeQry qry) {
        MultiResponse<SysNoticeCO> list = sysNoticeService.queryAll(qry);
        ExcelUtil<SysNoticeCO> util = new ExcelUtil<SysNoticeCO>(SysNoticeCO.class);
        util.exportExcel(response, list.getData(), "通知公告表数据");
    }
    /* 基础接口结束 */

}
