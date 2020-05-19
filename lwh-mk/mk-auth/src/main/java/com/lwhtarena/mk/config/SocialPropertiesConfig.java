package com.lwhtarena.mk.config;

import lombok.Data;

/**
 * @author liwh
 * @Title: SocialPropertiesConfig
 * @Package com.lwhtarena.mk.config
 * @Description: social 登录基础配置
 * @Version 1.0.0
 * @date 2020/5/19 21:52
 */
@Data
public class SocialPropertiesConfig {
    /**
     * 提供商
     */
    private String providerId;
    /**
     * 应用ID
     */
    private String clientId;
    /**
     * 应用密钥
     */
    private String clientSecret;

}
