package com.wyl.dict.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.dict.gatewayimpl.database.dataobject.SysDictData;
import com.wyl.dict.domain.gateway.SysDictDataGateway;
import com.wyl.dict.gatewayimpl.database.SysDictDataDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 字典数据表(SysDictData)表网关接口
 *
 * @author wyl
 * @since 2021-12-17 21:35:55
 */
@Component
public class SysDictDataGatewayImpl implements SysDictDataGateway {

    @Resource
    private SysDictDataDao sysDictDataDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysDictData queryByPrimaryKey(Long primaryKey) {
        SysDictData sysDictData = this.sysDictDataDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysDictData, "查询对象不存在");
        return sysDictData;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictData 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysDictData> queryAll(SysDictData sysDictData) {
        return this.sysDictDataDao.queryAll(sysDictData);
    }

    /**
     * 查询单条数据
     *
     * @param sysDictData 实例对象
     * @return
     */
    @Override
    public SysDictData queryOne(SysDictData sysDictData) {
        List<SysDictData> list = this.sysDictDataDao.queryAll(sysDictData);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysDictData 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysDictData> queryPage(SysDictData sysDictData) {
        PageHelper.startPage(sysDictData.getPageIndex(), sysDictData.getPageSize());
        List<SysDictData> list = sysDictDataDao.queryAll(sysDictData);
        PageInfo<SysDictData> pageInfo = new PageInfo<SysDictData>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysDictData 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysDictData sysDictData) {
        sysDictDataDao.insert(sysDictData);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictData> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysDictData> entities) {
        sysDictDataDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysDictData> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysDictData> entities) {
        sysDictDataDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysDictData 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysDictData sysDictData) {
        Assert.isTrue(sysDictDataDao.update(sysDictData) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysDictDataDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

