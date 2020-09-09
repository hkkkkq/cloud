package com.lwhtarena.glmall.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liwh
 * @Title: WxAccountConfig
 * @Package com.lwhtarena.glmall.order.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:57
 */

@Component
@ConfigurationProperties(prefix = "wx")
@Data
public class WxAccountConfig {

    private String appId;

    private String mchId;

    private String mchKey;

    private String notifyUrl;

    private String returnUrl;

}
