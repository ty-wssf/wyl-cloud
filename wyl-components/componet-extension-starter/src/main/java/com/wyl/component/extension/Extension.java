package com.wyl.component.extension;

import java.lang.annotation.*;

/**
 * 标识扩展接口实现
 *
 * @author wyl
 * @since 2021-11-17 15:47:47
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Extension {

    String value() default "";

}
