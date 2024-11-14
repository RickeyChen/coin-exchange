package com.ricky.config;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@EnableAuthorizationServer
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private UserDetailsService userDetailsService;

    // 添加第三方客户端
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("coin-api")
                .secret(passwordEncoder.encode("123456"))
                .scopes("all")
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(3600);
    }

    // 配置验证管理器,UserDetailsService
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

}
