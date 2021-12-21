package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysRoleDept;
import com.wyl.upms.domain.gateway.SysRoleDeptGateway;
import com.wyl.upms.gatewayimpl.database.SysRoleDeptDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色和部门关联表(SysRoleDept)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:39
 */
@Component
public class SysRoleDeptGatewayImpl implements SysRoleDeptGateway {

    @Resource
    private SysRoleDeptDao sysRoleDeptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysRoleDept queryByPrimaryKey(Long primaryKey) {
        SysRoleDept sysRoleDept = this.sysRoleDeptDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysRoleDept, "查询对象不存在");
        return sysRoleDept;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleDept 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysRoleDept> queryAll(SysRoleDept sysRoleDept) {
        return this.sysRoleDeptDao.queryAll(sysRoleDept);
    }

    /**
     * 查询单条数据
     *
     * @param sysRoleDept 实例对象
     * @return
     */
    @Override
    public SysRoleDept queryOne(SysRoleDept sysRoleDept) {
        List<SysRoleDept> list = this.sysRoleDeptDao.queryAll(sysRoleDept);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysRoleDept 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysRoleDept> queryPage(SysRoleDept sysRoleDept) {
        PageHelper.startPage(sysRoleDept.getPageQuery().getPageIndex(), sysRoleDept.getPageQuery().getPageSize());
        List<SysRoleDept> list = sysRoleDeptDao.queryAll(sysRoleDept);
        PageInfo<SysRoleDept> pageInfo = new PageInfo<SysRoleDept>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysRoleDept 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysRoleDept sysRoleDept) {
        sysRoleDeptDao.insert(sysRoleDept);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleDept> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysRoleDept> entities) {
        sysRoleDeptDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysRoleDept> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysRoleDept> entities) {
        sysRoleDeptDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysRoleDept 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysRoleDept sysRoleDept) {
        Assert.isTrue(sysRoleDeptDao.update(sysRoleDept) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysRoleDeptDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

