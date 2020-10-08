package com.lwhtarena.glmall.order.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.fastjson.JSON;
import com.lwhtarena.common.exception.BizCodeEnume;
import com.lwhtarena.common.utils.R;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liwh
 * @Title: GulimallOrderSentinelConfig
 * @Package com.lwhtarena.glmall.order.config
 * @Description: 自定义阻塞返回方法
 *
 *  `Spring Cloud Alibaba Sentinel` 不再依赖 `sentinel-web-servlet` 实现，而是依赖 `sentinel-spring-webmvc-dapter` ,
 *  基于 Spring 的 `Interceptor` 拦截资源,而不再是 `CommonFilter`。
 * @Version 1.0.0
 * @date 2020/9/9 16:52
 */

@Configuration
public class GulimallOrderSentinelConfig {

    @Bean
    public BlockExceptionHandler sentinelBlockExceptionHandler() {
        return (request, response, e) -> {
            // 429 Too Many Requests
            response.setStatus(429);
            R error = R.error(BizCodeEnume.TO_MANY_REQUEST.getCode(), BizCodeEnume.TO_MANY_REQUEST.getMsg());
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JSON.toJSONString(error));
        };
    }
}
