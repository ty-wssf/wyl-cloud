package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysRole;
import com.wyl.upms.domain.gateway.SysRoleGateway;
import com.wyl.upms.gatewayimpl.database.SysRoleDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色信息表(SysRole)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:37
 */
@Component
public class SysRoleGatewayImpl implements SysRoleGateway {

    @Resource
    private SysRoleDao sysRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysRole queryByPrimaryKey(Long primaryKey) {
        SysRole sysRole = this.sysRoleDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysRole, "查询对象不存在");
        return sysRole;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRole 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysRole> queryAll(SysRole sysRole) {
        return this.sysRoleDao.queryAll(sysRole);
    }

    /**
     * 查询单条数据
     *
     * @param sysRole 实例对象
     * @return
     */
    @Override
    public SysRole queryOne(SysRole sysRole) {
        List<SysRole> list = this.sysRoleDao.queryAll(sysRole);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRole 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysRole> queryPage(SysRole sysRole) {
        PageHelper.startPage(sysRole.getPageQuery().getPageIndex(), sysRole.getPageQuery().getPageSize());
        List<SysRole> list = sysRoleDao.queryAll(sysRole);
        PageInfo<SysRole> pageInfo = new PageInfo<SysRole>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysRole sysRole) {
        sysRoleDao.insert(sysRole);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRole> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysRole> entities) {
        sysRoleDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRole> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysRole> entities) {
        sysRoleDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysRole sysRole) {
        Assert.isTrue(sysRoleDao.update(sysRole) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysRoleDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

    @Override
    public List<SysRole> queryRolesByUserId(Long userId) {
        return sysRoleDao.queryRolesByUserId(userId);
    }

}

