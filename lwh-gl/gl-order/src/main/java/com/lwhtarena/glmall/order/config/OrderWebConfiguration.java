package com.lwhtarena.glmall.order.config;

import com.lwhtarena.glmall.order.interceptor.LoginUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liwh
 * @Title: OrderWebConfig
 * @Package com.lwhtarena.glmall.order.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:57
 */
@Configuration
public class OrderWebConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginUserInterceptor loginUserInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginUserInterceptor).addPathPatterns("/**");
    }
}
