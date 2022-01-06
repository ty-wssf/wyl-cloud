package com.wyl.auth.config;

import com.wyl.auth.security.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 认证相关配置
 */
@Primary
@Order(90)
@Configuration
@AllArgsConstructor
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    @SneakyThrows
    protected void configure(HttpSecurity http) {
        http.formLogin().loginPage("/token/login").loginProcessingUrl("/token/form")
                /*.failureHandler(authenticationFailureHandler())*/.and().logout()
                /*.logoutSuccessHandler(logoutSuccessHandler())*/
                .deleteCookies("JSESSIONID").invalidateHttpSession(true)
                .and().authorizeRequests().antMatchers("/token/**", "/actuator/**", "/mobile/**").permitAll()
                .anyRequest().authenticated().and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义认证与授权
        auth.userDetailsService(userDetailsService());
        // 基于内存存储用户
        /*auth.inMemoryAuthentication()
                // 在内存中创建用户并为密码加密
                .withUser("user").password(passwordEncoder().encode("123456")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("123456")).roles("ADMIN");*/
    }

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * 认证管理器
     *
     * @return
     */
    @Bean
    @Override
    @SneakyThrows
    public AuthenticationManager authenticationManagerBean() {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 设置默认的加密方式
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        new BCryptPasswordEncoder().encode("123456");
    }

}
