package com.wyl.dict.gatewayimpl.database;

import com.wyl.dict.gatewayimpl.database.dataobject.SysNotice;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 通知公告表(SysNotice)表数据库访问层
 *
 * @author wyl
 * @since 2021-12-15 09:07:22
 */
public interface SysNoticeDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param primaryKey 主键
     * @return 实例对象
     */
    SysNotice queryByPrimaryKey(Integer primaryKey);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysNotice 实例对象
     * @return 对象列表
     */
    List<SysNotice> queryAll(SysNotice sysNotice);

    /**
     * 新增数据
     *
     * @param sysNotice 实例对象
     * @return 影响行数
     */
    int insert(SysNotice sysNotice);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysNotice> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysNotice> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysNotice> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SysNotice> entities);

    /**
     * 修改数据
     *
     * @param sysNotice 实例对象
     * @return 影响行数
     */
    int update(SysNotice sysNotice);
    
    /**
     * 通过主键删除数据
     *
     * @param primaryKey 主键
     * @return 影响行数
     */
    int deleteByPrimaryKey(Integer primaryKey);
    
}