package com.kimzing.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * @EnableWebFluxSecurity  开启 Security 对 WebFlux 的安全功能
 */
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        // 创建一个默认用户
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .roles("USER")
                .build();

        // 创建 MapReactiveUserDetailsService
        return new MapReactiveUserDetailsService(user);
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        // 设置权限配置
        http.authorizeExchange(exchanges ->
                exchanges
                        // 静态资源，允许匿名访问
                        .pathMatchers("/assets/**").permitAll()
                        // 登录接口，允许匿名访问
                        .pathMatchers("/login").permitAll()
                        .anyExchange().authenticated()
        )
        // 登录页面
        .formLogin().loginPage("/login")
        // 登出界面
        .and().logout().logoutUrl("/logout")
        // HTTP Basic 认证方式
        .and().httpBasic()
        // csrf 禁用
        .and().csrf().disable();
        return http.build();
    }

}