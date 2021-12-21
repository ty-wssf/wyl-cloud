package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysPost;
import com.wyl.upms.domain.gateway.SysPostGateway;
import com.wyl.upms.gatewayimpl.database.SysPostDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 岗位信息表(SysPost)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 09:48:15
 */
@Component
public class SysPostGatewayImpl implements SysPostGateway {

    @Resource
    private SysPostDao sysPostDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysPost queryByPrimaryKey(Long primaryKey) {
        SysPost sysPost = this.sysPostDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysPost, "查询对象不存在");
        return sysPost;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPost 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysPost> queryAll(SysPost sysPost) {
        return this.sysPostDao.queryAll(sysPost);
    }

    /**
     * 查询单条数据
     *
     * @param sysPost 实例对象
     * @return
     */
    @Override
    public SysPost queryOne(SysPost sysPost) {
        List<SysPost> list = this.sysPostDao.queryAll(sysPost);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysPost 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysPost> queryPage(SysPost sysPost) {
        PageHelper.startPage(sysPost.getPageQuery().getPageIndex(), sysPost.getPageQuery().getPageSize());
        List<SysPost> list = sysPostDao.queryAll(sysPost);
        PageInfo<SysPost> pageInfo = new PageInfo<SysPost>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysPost 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysPost sysPost) {
        sysPostDao.insert(sysPost);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysPost> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysPost> entities) {
        sysPostDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysPost> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysPost> entities) {
        sysPostDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysPost 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysPost sysPost) {
        Assert.isTrue(sysPostDao.update(sysPost) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysPostDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

