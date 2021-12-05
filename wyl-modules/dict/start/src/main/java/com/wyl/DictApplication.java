package com.wyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@EnableFeignClients(basePackages = "cn.wyl")
@SpringBootApplication(scanBasePackages = {"com.wyl"})
@MapperScan("com.wyl.dict.gatewayimpl.database")
public class DictApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictApplication.class, args);
    }
}
