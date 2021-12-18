package cn.wyl.common.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import java.util.Map;

/**
 * Page Query Param
 *
 * @author jacky
 */
public class PageQuery extends Query {
    private static final long serialVersionUID = 1L;

    private static final int DEFAULT_PAGE_SIZE = 10;

    @ApiModelProperty(value = "每页显示多少条")
    private int pageSize = DEFAULT_PAGE_SIZE;

    @ApiModelProperty(value = "页索引")
    private int pageIndex = 1;

    public int getPageIndex() {
        if (pageIndex < 1) {
            return 1;
        }
        return pageIndex;
    }

    public PageQuery setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return pageSize;
    }

    public PageQuery setPageSize(int pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
        return this;
    }

    @ApiModelProperty(hidden = true)
    public int getOffset() {
        return (getPageIndex() - 1) * getPageSize();
    }

    @ApiModelProperty(hidden = true)
    public Map<String, Object> getParams() {
        return getParams();
    }

}
