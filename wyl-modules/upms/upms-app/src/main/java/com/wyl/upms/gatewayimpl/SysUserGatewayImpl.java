package com.wyl.upms.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.upms.gatewayimpl.database.dataobject.SysUser;
import com.wyl.upms.domain.gateway.SysUserGateway;
import com.wyl.upms.gatewayimpl.database.SysUserDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表(SysUser)表网关接口
 *
 * @author wyl
 * @since 2021-12-21 13:22:47
 */
@Component
public class SysUserGatewayImpl implements SysUserGateway {

    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryByPrimaryKey(Long primaryKey) {
        SysUser sysUser = this.sysUserDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysUser, "查询对象不存在");
        return sysUser;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAll(SysUser sysUser) {
        return this.sysUserDao.queryAll(sysUser);
    }

    /**
     * 查询单条数据
     *
     * @param sysUser 实例对象
     * @return
     */
    @Override
    public SysUser queryOne(SysUser sysUser) {
        List<SysUser> list = this.sysUserDao.queryAll(sysUser);
        Assert.notEmpty(list, "无结果");
        Assert.isTrue(list.size() > 0, "查询到多条数据");
        return list.get(0);
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysUser 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysUser> queryPage(SysUser sysUser) {
        PageHelper.startPage(sysUser.getPageQuery().getPageIndex(), sysUser.getPageQuery().getPageSize());
        List<SysUser> list = sysUserDao.queryAll(sysUser);
        PageInfo<SysUser> pageInfo = new PageInfo<SysUser>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysUser sysUser) {
        sysUserDao.insert(sysUser);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysUser> entities) {
        sysUserDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysUser> entities) {
        sysUserDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysUser sysUser) {
        Assert.isTrue(sysUserDao.update(sysUser) > 0, "编辑对象不存在");
    }

    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Long primaryKey) {
        Assert.isTrue(sysUserDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }

    @Override
    public SysUser queryByUserName(String userName) {
        return sysUserDao.queryOneByUserName(userName);
    }

    @Override
    public SysUser queryByPhonenumber(String phonenumber) {
        return sysUserDao.queryOneByPhonenumber(phonenumber);
    }

    @Override
    public SysUser queryByEmail(String email) {
        return sysUserDao.queryOneByEmail(email);
    }

}

