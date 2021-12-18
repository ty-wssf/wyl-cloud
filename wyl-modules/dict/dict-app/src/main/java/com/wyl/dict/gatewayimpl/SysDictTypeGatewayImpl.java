package com.wyl.dict.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictType;
import com.wyl.dict.domain.gateway.SysDictTypeGateway;
import com.wyl.dict.gatewayimpl.database.SysDictTypeDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典类型表(SysDictType)表网关接口
 *
 * @author wyl
 * @since 2021-12-17 21:25:59
 */
@Component
public class SysDictTypeGatewayImpl implements SysDictTypeGateway {

    @Resource
    private SysDictTypeDao sysDictTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysDictType queryByPrimaryKey(Long primaryKey) {
        SysDictType sysDictType = this.sysDictTypeDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysDictType, "查询对象不存在");
        return sysDictType;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictType 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysDictType> queryAll(SysDictType sysDictType) {
        return this.sysDictTypeDao.queryAll(sysDictType);
    }

    /**
     * 查询单条数据
     *
     * @param sysDictType 实例对象
     * @return
     */
    @Override
    public SysDictType queryOne(SysDictType sysDictType) {
        List<SysDictType> list = this.sysDictTypeDao.queryAll(sysDictType);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictType 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysDictType> queryPage(SysDictType sysDictType) {
        PageHelper.startPage(sysDictType.getPageQuery().getPageIndex(), sysDictType.getPageQuery().getPageSize());
        List<SysDictType> list = sysDictTypeDao.queryAll(sysDictType);
        PageInfo<SysDictType> pageInfo = new PageInfo<SysDictType>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysDictType 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysDictType sysDictType) {
        sysDictTypeDao.insert(sysDictType);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictType> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysDictType> entities) {
        sysDictTypeDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictType> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysDictType> entities) {
        sysDictTypeDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysDictType 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysDictType sysDictType) {
        Assert.isTrue(sysDictTypeDao.update(sysDictType) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysDictTypeDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

