package com.wyl.auth.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

@AllArgsConstructor
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    private final DataSource dataSource;
    private final TokenStore redisTokenStore;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.allowFormAuthenticationForClients().checkTokenAccess("permitAll()");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                /*.tokenServices(tokenServices())*/
                .tokenStore(redisTokenStore)
                /*.tokenEnhancer(tokenEnhancer())*/
                /*.userDetailsService(userDetailsService)*/
                // 配置认证管理器，密码模式依赖于认证管理器
                .authenticationManager(authenticationManager).reuseRefreshTokens(false)
                .pathMapping("/oauth/confirm_access", "/token/confirm_access");
        /* .exceptionTranslator(new PigWebResponseExceptionTranslator());*/
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置客户端   // 使用内存设置
        /*InMemoryClientDetailsServiceBuilder inMemoryClientBuilder = clients.inMemory();
        inMemoryClientBuilder
                // client_id
                .withClient("client")
                // client_secret  // 还需要为 secret 加密
                .secret(passwordEncoder.encode("secret"))
                // 授权类型
                .authorizedGrantTypes("authorization_code")
                // 授权范围
                .scopes("app")
                // 自动同意授权
                //.autoApprove("true")
                // 注册回调地址
                .redirectUris("http://www.funtl.com");*/
        // 读取客户端配置
        clients.withClientDetails(jdbcClientDetails());
    }

    @Bean
    public ClientDetailsService jdbcClientDetails() {
        // 基于 JDBC 实现，需要事先在数据库配置客户端信息
        return new JdbcClientDetailsService(dataSource);
    }


}
