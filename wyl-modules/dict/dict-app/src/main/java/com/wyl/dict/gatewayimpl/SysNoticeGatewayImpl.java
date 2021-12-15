package com.wyl.dict.gatewayimpl;

import cn.wyl.common.core.exception.Assert;
import com.wyl.dict.gatewayimpl.database.dataobject.SysNotice;
import com.wyl.dict.domain.gateway.SysNoticeGateway;
import com.wyl.dict.gatewayimpl.database.SysNoticeDao;
import org.apache.ibatis.annotations.Param;
import cn.wyl.common.core.dto.PageResponse;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * 通知公告表(SysNotice)表网关接口
 *
 * @author wyl
 * @since 2021-12-15 09:07:24
 */
@Component
public class SysNoticeGatewayImpl implements SysNoticeGateway {
       
    @Resource
    private SysNoticeDao sysNoticeDao;
    
    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    @Override
    public SysNotice queryByPrimaryKey(Integer primaryKey) {
        SysNotice sysNotice = this.sysNoticeDao.queryByPrimaryKey(primaryKey);
        Assert.notNull(sysNotice, "查询对象不存在");
        return sysNotice;
    }

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysNotice 实例对象
     * @return 对象列表
     */
    @Override
    public List<SysNotice> queryAll(SysNotice sysNotice) {
        return this.sysNoticeDao.queryAll(sysNotice);
    }
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysNotice 实例对象
     * @return 对象列表
     */
    @Override
    public PageResponse<SysNotice> queryPage(SysNotice sysNotice) {
        PageHelper.startPage(sysNotice.getPageIndex(), sysNotice.getPageSize());
        List<SysNotice> list = sysNoticeDao.queryAll(sysNotice);
        PageInfo<SysNotice> pageInfo = new PageInfo<SysNotice>(list);
        return PageResponse.of(pageInfo.getList(), (int) pageInfo.getTotal(), pageInfo.getPageSize(), pageInfo.getPageNum());
    }
    
    /**
     * 新增数据
     *
     * @param sysNotice 实例对象
     * @return 影响行数
     */
    @Override
    public void insert(SysNotice sysNotice) {
        sysNoticeDao.insert(sysNotice);
    }

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysNotice> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertBatch(@Param("entities") List<SysNotice> entities) {
        sysNoticeDao.insertBatch(entities);
    }

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysNotice> 实例对象列表
     * @return 影响行数
     */
    @Override
    public void insertOrUpdateBatch(@Param("entities") List<SysNotice> entities) {
        sysNoticeDao.insertOrUpdateBatch(entities);
    }

    /**
     * 修改数据
     *
     * @param sysNotice 实例对象
     * @return 影响行数
     */
    @Override
    public void update(SysNotice sysNotice) {
        Assert.isTrue(sysNoticeDao.update(sysNotice) > 0, "编辑对象不存在");
    }
    
    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    @Override
    public void deleteByPrimaryKey(Integer primaryKey) {
        Assert.isTrue(sysNoticeDao.deleteByPrimaryKey(primaryKey) > 0, "删除对象不存在");
    }
    
}