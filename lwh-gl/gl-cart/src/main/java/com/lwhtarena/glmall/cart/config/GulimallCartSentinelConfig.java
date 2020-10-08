package com.lwhtarena.glmall.cart.config;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.fastjson.JSON;
import com.lwhtarena.common.exception.BizCodeEnume;
import com.lwhtarena.common.utils.R;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liwh
 * @Title: GulimallCartSentinelConfig
 * @Package com.lwhtarena.glmall.cart.config
 * @Description: 自定义阻塞返回方法
 * @Version 1.0.0
 * @date 2020/10/9 03:42
 */

@Configuration
public class GulimallCartSentinelConfig {

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

