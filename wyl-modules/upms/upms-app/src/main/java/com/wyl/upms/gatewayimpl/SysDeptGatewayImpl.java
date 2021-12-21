package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysDept;
import com.wyl.upms.domain.gateway.SysDeptGateway;
import com.wyl.upms.gatewayimpl.database.SysDeptDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 部门表(SysDept)表网关接口
 *
 * @author wyl
 * @since 2021-12-20 16:18:44
 */
@Component
public class SysDeptGatewayImpl implements SysDeptGateway {

    @Resource
    private SysDeptDao sysDeptDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysDept queryByPrimaryKey(Long primaryKey) {
        SysDept sysDept = this.sysDeptDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysDept, "查询对象不存在");
        return sysDept;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDept 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysDept> queryAll(SysDept sysDept) {
        return this.sysDeptDao.queryAll(sysDept);
    }

    /**
     * 查询单条数据
     *
     * @param sysDept 实例对象
     * @return
     */
    @Override
    public SysDept queryOne(SysDept sysDept) {
        List<SysDept> list = this.sysDeptDao.queryAll(sysDept);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDept 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysDept> queryPage(SysDept sysDept) {
        PageHelper.startPage(sysDept.getPageQuery().getPageIndex(), sysDept.getPageQuery().getPageSize());
        List<SysDept> list = sysDeptDao.queryAll(sysDept);
        PageInfo<SysDept> pageInfo = new PageInfo<SysDept>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysDept 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysDept sysDept) {
        sysDeptDao.insert(sysDept);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDept> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysDept> entities) {
        sysDeptDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDept> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysDept> entities) {
        sysDeptDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysDept 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysDept sysDept) {
        Assert.isTrue(sysDeptDao.update(sysDept) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysDeptDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

