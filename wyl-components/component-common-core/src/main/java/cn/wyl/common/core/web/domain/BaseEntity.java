package cn.wyl.common.core.web.domain;

import cn.wyl.common.core.dto.PageQuery;
import cn.wyl.common.core.mybatis.CreatedOnFuncation;
import cn.wyl.common.core.mybatis.UpdatedOnFuncation;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseEntity implements Serializable {

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    @CreatedOnFuncation
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    @UpdatedOnFuncation
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    private PageQuery pageQuery;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public PageQuery getPageQuery() {
        return pageQuery;
    }

    public void setPageQuery(PageQuery pageQuery) {
        this.pageQuery = pageQuery;
    }

}
