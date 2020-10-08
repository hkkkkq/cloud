package com.lwhtarena.glmall.cart.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liwh
 * @Title: ThreadPoolConfigProperties
 * @Package com.lwhtarena.glmall.cart.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 03:44
 */
@ConfigurationProperties(prefix = "gulimall.thread")
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAliveTime;


}
