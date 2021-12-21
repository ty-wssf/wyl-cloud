package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUserPost;
import com.wyl.upms.domain.gateway.SysUserPostGateway;
import com.wyl.upms.gatewayimpl.database.SysUserPostDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户与岗位关联表(SysUserPost)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:52
 */
@Component
public class SysUserPostGatewayImpl implements SysUserPostGateway {

    @Resource
    private SysUserPostDao sysUserPostDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysUserPost queryByPrimaryKey(Long primaryKey) {
        SysUserPost sysUserPost = this.sysUserPostDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysUserPost, "查询对象不存在");
        return sysUserPost;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserPost 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysUserPost> queryAll(SysUserPost sysUserPost) {
        return this.sysUserPostDao.queryAll(sysUserPost);
    }

    /**
     * 查询单条数据
     *
     * @param sysUserPost 实例对象
     * @return
     */
    @Override
    public SysUserPost queryOne(SysUserPost sysUserPost) {
        List<SysUserPost> list = this.sysUserPostDao.queryAll(sysUserPost);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUserPost 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysUserPost> queryPage(SysUserPost sysUserPost) {
        PageHelper.startPage(sysUserPost.getPageQuery().getPageIndex(), sysUserPost.getPageQuery().getPageSize());
        List<SysUserPost> list = sysUserPostDao.queryAll(sysUserPost);
        PageInfo<SysUserPost> pageInfo = new PageInfo<SysUserPost>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysUserPost 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysUserPost sysUserPost) {
        sysUserPostDao.insert(sysUserPost);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserPost> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysUserPost> entities) {
        sysUserPostDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUserPost> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysUserPost> entities) {
        sysUserPostDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysUserPost 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysUserPost sysUserPost) {
        Assert.isTrue(sysUserPostDao.update(sysUserPost) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysUserPostDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

}

