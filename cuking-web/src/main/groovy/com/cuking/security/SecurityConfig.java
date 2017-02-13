package com.cuking.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by cuking on 2017/2/6.
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    //身份验证的配置 用于注入自定义的身份验证和密码校验的规则
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //在内存中新增一个用户 用户名:user 密码:password  角色: USER
        //auth.userDetailsService( customUserService());
        auth.authenticationProvider(authenticationProvider());
        //13015595979
    }


    //自定义配置 Request层面的配置,对应XML Configuration 中的<http> 元素
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/", "/register", "login","/u/i","/u/r").permitAll() //指定  /  和 home 不需要认证就可以访问
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/u/i").defaultSuccessUrl("/u/s").permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
//                .rememberMe()
//                //设置cookie有效期
//                .tokenValiditySeconds(60 * 60 * 24 * 7)
//                //设置cookie的私钥
//                //.key("cuking")
//        ;
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and()
                .logout()
                .permitAll();
    }


    //web 层面的配置,一般用来配置无需安全检查的路径
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**", "/**/favicon.ico");
    }
}
