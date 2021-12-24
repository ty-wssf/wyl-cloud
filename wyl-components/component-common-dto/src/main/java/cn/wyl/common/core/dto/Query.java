package cn.wyl.common.core.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Query request from Client.
 *
 * @author Frank Zhang 2020.11.13
 */
@Setter
@Getter
public abstract class Query extends Command {

    private static final long serialVersionUID = 1L;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

}
