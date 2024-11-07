package com.chloe.security.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails zhangsan = User.withUsername("zhangsan")
                .password(passwordEncoder.encode("123456"))
                .roles("admin", "market")
                .authorities("file_write", "file_read")
                .build();

        UserDetails lisi = User.withUsername("lisi")
                .password(passwordEncoder.encode("123456"))
                .roles( "market")
                .authorities("file_read")
                .build();

        UserDetails wangwu = User.withUsername("wangwu")
                .password(passwordEncoder.encode("123456"))
                .roles("admin","world_role")
                .authorities("file_write")
                .build();
        return new InMemoryUserDetailsManager(zhangsan,lisi,wangwu);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
