package com.lwhtarena.glmall.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author liwh
 * @Title: ThreadPoolConfigProperties
 * @Package com.lwhtarena.glmall.order.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:57
 */

@ConfigurationProperties(prefix = "gulimall.thread")
@Data
public class ThreadPoolConfigProperties {

    private Integer coreSize;

    private Integer maxSize;

    private Integer keepAliveTime;
}
