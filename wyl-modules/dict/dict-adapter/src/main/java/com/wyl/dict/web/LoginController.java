package com.wyl.dict.web;

import cn.hutool.core.collection.ListUtil;
import cn.wyl.common.core.dto.SingleResponse;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping()
@RestController
public class LoginController {

    @PostMapping("/vue-admin-template/user/login")
    public SingleResponse<Token> login(@RequestBody UserNameForm userNameForm) {
        return SingleResponse.of(Token.builder().token("admin-token").build());
    }

    @GetMapping("/vue-admin-template/user/info")
    public SingleResponse<User> getUserInfo(String token) {
        return SingleResponse.of(User.builder()
                .avatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
                .introduction("I am a super administrator")
                .name("Super Admin")
                .roles(ListUtil.of("admin"))
                .build());
    }

}

@Builder
@Data
class Token {
    private String token;
}

@Data
class UserNameForm {
    private String username;
    private String password;
}

@Builder
@Data
class User {
    private String avatar;
    private String introduction;
    private String name;
    private List<String> roles;
}