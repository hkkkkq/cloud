package com.lwhtarena.mk.common.bean.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author liwh
 * @Title: QiniuPropertiesConfig
 * @Package com.lwhtarena.mk.common.config
 * @Description: 七牛参数
 * @Version 1.0.0
 * @date 2020/5/19 19:01
 */
@Configuration
@ConditionalOnProperty(prefix = "qiniu", name = "accessKey")
@ConfigurationProperties(prefix = "qiniu")
public class QiniuPropertiesConfig {
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String qiniuHost;

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getQiniuHost() {
        return qiniuHost;
    }

    public void setQiniuHost(String qiniuHost) {
        this.qiniuHost = qiniuHost;
    }
}
