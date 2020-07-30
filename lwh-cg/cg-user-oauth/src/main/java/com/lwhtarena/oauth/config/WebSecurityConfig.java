package com.lwhtarena.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author liwh
 * @Title: WebSecurityConfig
 * @Package com.lwhtarena.oauth.config
 * @Description:
 *
 * @Version 1.0.0
 * @date 2020/7/17 10:12
 */
@Configuration
@EnableWebSecurity
@Order(-1)
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /***
     * 针对静态资源和登录页，我们需要实现忽略安全配置，并且要指定登录页面
     * 忽略安全拦截的URL
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        /**放行地址配置**/
        web.ignoring().antMatchers(
                "/user/login",
                "/user/logout","/oauth/login","/css/**","/data/**","/fonts/**","/img/**","/js/**");
    }

    /***
     * 创建授权管理认证对象
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    /***
     * 采用BCryptPasswordEncoder对密码进行编码
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /****
     *
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic()        //启用Http基本身份验证
                .and()
                .formLogin()       //启用表单身份验证
                .loginPage("/oauth/login") //自定义登录地址
                .loginProcessingUrl("/user/login") //登录处理地址（SpringSecurity内置地址）
                .and()
                .authorizeRequests()    //限制基于Request请求访问
                .antMatchers("/oauth/**","/login/**","/logout/**")
                .permitAll()
                .anyRequest()
                .authenticated();       //其他请求都需要经过验证
    }
}
