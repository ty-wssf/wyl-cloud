package com.wyl.dict.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.dict.gatewayimpl.database.dataobject.SysConfig;
import com.wyl.dict.domain.gateway.SysConfigGateway;
import com.wyl.dict.gatewayimpl.database.SysConfigDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 参数配置表(SysConfig)表网关接口
 *
 * @author wyl
 * @since 2021-12-17 16:35:45
 */
@Component
public class SysConfigGatewayImpl implements SysConfigGateway {

    @Resource
    private SysConfigDao sysConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysConfig queryByPrimaryKey(Long primaryKey) {
        SysConfig sysConfig = this.sysConfigDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysConfig, "查询对象不存在");
        return sysConfig;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysConfig 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysConfig> queryAll(SysConfig sysConfig) {
        return this.sysConfigDao.queryAll(sysConfig);
    }

    /**
     * 查询单条数据
     *
     * @param sysConfig 实例对象
     * @return
     */
    @Override
    public SysConfig queryOne(SysConfig sysConfig) {
        List<SysConfig> list = this.sysConfigDao.queryAll(sysConfig);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysConfig 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysConfig> queryPage(SysConfig sysConfig) {
        PageHelper.startPage(sysConfig.getPageIndex(), sysConfig.getPageSize());
        List<SysConfig> list = sysConfigDao.queryAll(sysConfig);
        PageInfo<SysConfig> pageInfo = new PageInfo<SysConfig>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysConfig 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysConfig sysConfig) {
        sysConfigDao.insert(sysConfig);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysConfig> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysConfig> entities) {
        sysConfigDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysConfig> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysConfig> entities) {
        sysConfigDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysConfig 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysConfig sysConfig) {
        Assert.isTrue(sysConfigDao.update(sysConfig) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysConfigDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

