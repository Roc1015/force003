package com.example.demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author WP
 * @date 2020/12/31  16:04
 */
@EnableWebSecurity
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Override
    //授权
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问
        //内部页面分权限
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasAnyRole("vip1")
                .antMatchers("/level2/**").hasAnyRole("vip2")
                .antMatchers("/level3/**").hasAnyRole("vip3");

        //没有权限跳转到登录页面,需要开启登录页面
        http.formLogin();
        //注销
        http.logout().logoutUrl("/");
    }

    //认证
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("wangpeng").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("654321")).roles("vip1","vip2","vip3")
                .and()
                .withUser("pengwang").password(new BCryptPasswordEncoder().encode("147258369")).roles("vip3");
    }
}
