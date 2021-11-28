package com.wyl.dto;

import com.alibaba.cola.dto.PageQuery;
import lombok.Data;

/**
 * @author wyl
 * @since 2021-11-22 17:53:50
 */
@Data
public class ConfigPageQry extends PageQuery {

    /**
     * 参数名称
     */
    private String configName;

}
