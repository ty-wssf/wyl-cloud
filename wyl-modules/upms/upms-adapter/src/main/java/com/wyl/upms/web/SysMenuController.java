package com.wyl.upms.web;

import cn.hutool.core.bean.BeanUtil;
import cn.wyl.common.core.dto.MultiResponse;
import cn.wyl.common.core.dto.PageResponse;
import cn.wyl.common.core.dto.Response;
import cn.wyl.common.core.dto.SingleResponse;
import cn.wyl.common.core.tree.TreeSupport;
import cn.wyl.common.core.utils.poi.ExcelUtil;
import cn.wyl.common.core.web.controller.BaseController;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.wyl.upms.dto.clientobject.SysMenuCO;
import com.wyl.upms.dto.clientobject.SysMenuTreeCO;
import com.wyl.upms.dto.command.SysMenuAddCommand;
import com.wyl.upms.dto.command.SysMenuEditCommand;
import com.wyl.upms.dto.qry.SysMenuPageQry;
import com.wyl.upms.dto.qry.SysMenuQry;
import com.wyl.upms.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 菜单权限表(SysMenu)表控制层
 *
 * @author wyl
 * @since 2021-12-21 13:24:10
 */
@ApiSort(30)
@Api(tags = "菜单权限表模块")
@RestController
@RequestMapping("sysMenu")
public class SysMenuController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private SysMenuService sysMenuService;

    /* 基础接口开始 */
    @ApiOperationSupport(order = 1)
    @ApiOperation(value = "分页列表")
    @GetMapping("/pageList")
    public PageResponse<SysMenuCO> pageList(SysMenuPageQry qry) {
        return this.sysMenuService.queryPage(qry);
    }

    @ApiOperationSupport(order = 2)
    @ApiOperation(value = "根据主键查询详情")
    @GetMapping(value = "/{id}")
    public SingleResponse<SysMenuCO> getInfo(@ApiParam(value = "主键", required = true)
                                             @PathVariable Long id) {
        return this.sysMenuService.queryByPrimaryKey(id);
    }

    @ApiOperationSupport(order = 3)
    @ApiOperation(value = "新增")
    @PostMapping
    public Response add(@Validated @RequestBody SysMenuAddCommand command) {
        return this.sysMenuService.insert(command);
    }

    @ApiOperationSupport(order = 4)
    @ApiOperation(value = "编辑")
    @PutMapping("{id}")
    public Response edit(@Validated @RequestBody SysMenuEditCommand command, @PathVariable Long id) {
        command.setMenuId(id);
        return this.sysMenuService.update(command);
    }

    @ApiOperationSupport(order = 5)
    @ApiOperation(value = "删除")
    @DeleteMapping("/{ids}")
    public Response remove(@ApiParam(value = "主键", required = true)
                           @PathVariable Long[] ids) {
        return this.sysMenuService.deleteByPrimaryKeys(ids);
    }

    @ApiOperationSupport(order = 6)
    @ApiOperation(value = "导出")
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysMenuQry qry) {
        MultiResponse<SysMenuCO> list = sysMenuService.queryAll(qry);
        ExcelUtil<SysMenuCO> util = new ExcelUtil<SysMenuCO>(SysMenuCO.class);
        util.exportExcel(response, list.getData(), "菜单权限表数据");
    }
    /* 基础接口结束 */

    @ApiOperationSupport(order = 11)
    @ApiOperation(value = "树结构菜单列表")
    @GetMapping("/tree")
    public MultiResponse<SysMenuTreeCO> treeList(SysMenuQry qry) {
        List<SysMenuCO> menuCOList = this.sysMenuService.queryAll(qry).getData();
        List<SysMenuTreeCO> treeList = menuCOList.stream().map(menuCO -> {
            SysMenuTreeCO treeCO = new SysMenuTreeCO();
            BeanUtil.copyProperties(menuCO, treeCO);
            return treeCO;
        }).collect(Collectors.toList());
        treeList = TreeSupport.list2tree(treeList, SysMenuTreeCO::setChildren);
        return MultiResponse.of(treeList);
    }

}
