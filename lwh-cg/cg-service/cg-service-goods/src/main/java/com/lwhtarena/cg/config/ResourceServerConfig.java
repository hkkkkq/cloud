package com.lwhtarena.cg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * @author liwh
 * @Title: ResourceServerConfig
 * @Package com.lwhtarena.cg.config
 * @Description: 开启资源服务认证
 * @Version 1.0.0
 * @date 2020/8/1 05:55
 */
@Configuration
// 开启 资源服务器(标识他是一个oauth2中的资源服务器)
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)//激活方法上的PreAuthorize注解
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    //公钥
    private static final String PUBLIC_KEY = "public.key";

    /***
     * 定义JwtTokenStore
     */
    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter jwtAccessTokenConverter) {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    /***
     * 定义JJwtAccessTokenConverter  用来校验令牌
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        String publicKey = getPubKey();
        converter.setVerifierKey(publicKey);
        //不设置这个会出现 Cannot convert access token to JSON
        converter.setVerifier(new RsaVerifier(publicKey));
        return converter;
    }
    /**
     * 获取非对称加密公钥 Key
     * @return 公钥 Key
     */
    private String getPubKey() {
        Resource resource = new ClassPathResource(PUBLIC_KEY);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(resource.getInputStream());
            BufferedReader br = new BufferedReader(inputStreamReader);
            return br.lines().collect(Collectors.joining("\n"));
        } catch (IOException ioe) {
            return null;
        }
    }

    /***
     * Http安全配置，对每个到达系统的http请求链接进行校验
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //放行 用户注册的请求
        //其他的请求  必须有登录之后才能访问 (校验token合法才可以访问)

        //所有请求必须认证通过
        http.authorizeRequests()
                //cg-user微服务需要放行的请求
                //.antMatchers("/user/add","/user/user/load/*").permitAll() //配置地址放行
                .antMatchers("/goods/spec/**")
                .permitAll() //配置地址放行
                .anyRequest().
                authenticated();    //其他地址需要认证授权
    }

}
