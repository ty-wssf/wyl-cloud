package com.wyl.component.extension;

import java.lang.annotation.*;

/**
 * Marker for extension interface
 *
 * @author wyl
 * @since 2021-11-17 15:41:54
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SPI {

}
