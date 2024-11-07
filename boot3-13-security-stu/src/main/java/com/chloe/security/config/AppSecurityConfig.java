package com.chloe.security.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * ClassName: AppSecurityConfig
 * Package: com.chloe.security.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/7 8:19
 * @Version 1.0
 */
@Configuration
public class AppSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
     /*   http.authorizeHttpRequests().anyRequest().authenticated();
        http.formLogin();
        http.httpBasic();
        return http.build();*/
        http.authorizeHttpRequests(registry ->{
            registry.requestMatchers("/").permitAll()//首页不跳转登录
                    .anyRequest().authenticated();
        });

        http.formLogin(formlogin -> {
            formlogin.loginPage("/login").permitAll();
        });
        return http.build();
    }
}
