package com.wyl.auth.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义用户认证与授权
 */
// @Component
public class UserDetailsServiceImpl implements UserDetailsService {

    //Autowired
    //private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        // 由框架完成认证工作
        return new User("admin", "$2a$10$b0f7VyazE0d8nqmmVGdHTOP5BaAc/MuOQi9UOnGXGt.b0I1Dt67Wy", grantedAuthorities);
    }

}
