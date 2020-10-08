package com.lwhtarena.glmall.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liwh
 * @Title: GulimallWebConfig
 * @Package com.lwhtarena.glmall.auth.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/29 16:51
 */
@Configuration
public class GulimallWebConfig implements WebMvcConfigurer {

    /**·
     * 视图映射:发送一个请求，直接跳转到一个页面
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/reg.html").setViewName("reg");
    }
}
