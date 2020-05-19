//package com.lwhtarena.mk.common.config;
//
//import com.lwhtarena.mk.common.bean.resolver.TokenArgumentResolver;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//import java.util.List;
//
///**
// * @author liwh
// * @Title: WebMvcConfig
// * @Package com.lwhtarena.mk.common.config
// * @Description: mvc配置
// * @Version 1.0.0
// * @date 2020/5/19 18:53
// */
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.add(new TokenArgumentResolver());
//    }
//}