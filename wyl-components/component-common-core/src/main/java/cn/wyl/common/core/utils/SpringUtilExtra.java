package cn.wyl.common.core.utils;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.aop.framework.AopContext;

/**
 * @author wyl
 * @since 2021-12-23 11:30:16
 */
public class SpringUtilExtra extends SpringUtil {

    /**
     * 获取aop代理对象
     *
     * @param invoker
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getAopProxy(T invoker) {
        return (T) AopContext.currentProxy();
    }

}
