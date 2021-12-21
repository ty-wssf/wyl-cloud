package com.wyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 通用权限管理模块启动类
 *
 * @author wyl
 * @since 2021-12-20 16:14:15
 */
@EnableFeignClients(basePackages = "cn.wyl")
@SpringBootApplication(scanBasePackages = {"com.wyl"})
@MapperScan("com.wyl.upms.gatewayimpl.database")
public class UpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UpmsApplication.class, args);
    }
}
