package com.lwhtarena.glmall.cart.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liwh
 * @Title: GulimallWebConfig
 * @Package com.lwhtarena.glmall.cart.interceptor
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 03:52
 */
@Configuration
public class GulimallWebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CartInterceptor())//注册拦截器
                .addPathPatterns("/**");
    }
}
