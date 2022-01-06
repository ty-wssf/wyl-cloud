package com.wyl.auth.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 控制层测试
 *
 * @author wyl
 * @since 2022-01-05 17:22:21
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
