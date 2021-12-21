package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysMenu;
import com.wyl.upms.domain.gateway.SysMenuGateway;
import com.wyl.upms.gatewayimpl.database.SysMenuDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单权限表(SysMenu)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:21:37
 */
@Component
public class SysMenuGatewayImpl implements SysMenuGateway {

    @Resource
    private SysMenuDao sysMenuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysMenu queryByPrimaryKey(Long primaryKey) {
        SysMenu sysMenu = this.sysMenuDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysMenu, "查询对象不存在");
        return sysMenu;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysMenu 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysMenu> queryAll(SysMenu sysMenu) {
        return this.sysMenuDao.queryAll(sysMenu);
    }

    /**
     * 查询单条数据
     *
     * @param sysMenu 实例对象
     * @return
     */
    @Override
    public SysMenu queryOne(SysMenu sysMenu) {
        List<SysMenu> list = this.sysMenuDao.queryAll(sysMenu);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysMenu 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysMenu> queryPage(SysMenu sysMenu) {
        PageHelper.startPage(sysMenu.getPageQuery().getPageIndex(), sysMenu.getPageQuery().getPageSize());
        List<SysMenu> list = sysMenuDao.queryAll(sysMenu);
        PageInfo<SysMenu> pageInfo = new PageInfo<SysMenu>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysMenu sysMenu) {
        sysMenuDao.insert(sysMenu);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysMenu> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysMenu> entities) {
        sysMenuDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysMenu> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysMenu> entities) {
        sysMenuDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysMenu sysMenu) {
        Assert.isTrue(sysMenuDao.update(sysMenu) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysMenuDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

