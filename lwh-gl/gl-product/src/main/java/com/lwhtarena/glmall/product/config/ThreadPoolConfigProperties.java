package com.lwhtarena.glmall.product.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liwh
 * @Title: ThreadPoolConfigProperties
 * @Package com.lwhtarena.glmall.product.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 12:13
 */
@ConfigurationProperties(prefix = "gulimall.thread")
// @Component
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAliveTime;


}
