package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysRoleMenu;
import com.wyl.upms.domain.gateway.SysRoleMenuGateway;
import com.wyl.upms.gatewayimpl.database.SysRoleMenuDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色和菜单关联表(SysRoleMenu)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:41
 */
@Component
public class SysRoleMenuGatewayImpl implements SysRoleMenuGateway {

    @Resource
    private SysRoleMenuDao sysRoleMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysRoleMenu queryByPrimaryKey(Long primaryKey) {
        SysRoleMenu sysRoleMenu = this.sysRoleMenuDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysRoleMenu, "查询对象不存在");
        return sysRoleMenu;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleMenu 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysRoleMenu> queryAll(SysRoleMenu sysRoleMenu) {
        return this.sysRoleMenuDao.queryAll(sysRoleMenu);
    }

    /**
     * 查询单条数据
     *
     * @param sysRoleMenu 实例对象
     * @return
     */
    @Override
    public SysRoleMenu queryOne(SysRoleMenu sysRoleMenu) {
        List<SysRoleMenu> list = this.sysRoleMenuDao.queryAll(sysRoleMenu);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleMenu 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysRoleMenu> queryPage(SysRoleMenu sysRoleMenu) {
        PageHelper.startPage(sysRoleMenu.getPageQuery().getPageIndex(), sysRoleMenu.getPageQuery().getPageSize());
        List<SysRoleMenu> list = sysRoleMenuDao.queryAll(sysRoleMenu);
        PageInfo<SysRoleMenu> pageInfo = new PageInfo<SysRoleMenu>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysRoleMenu 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysRoleMenu sysRoleMenu) {
        sysRoleMenuDao.insert(sysRoleMenu);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleMenu> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysRoleMenu> entities) {
        sysRoleMenuDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleMenu> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysRoleMenu> entities) {
        sysRoleMenuDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysRoleMenu 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysRoleMenu sysRoleMenu) {
        Assert.isTrue(sysRoleMenuDao.update(sysRoleMenu) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysRoleMenuDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

