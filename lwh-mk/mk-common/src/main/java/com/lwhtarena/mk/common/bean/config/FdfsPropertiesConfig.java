package com.lwhtarena.mk.common.bean.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author liwh
 * @Title: FdfsPropertiesConfig
 * @Package com.lwhtarena.mk.common.config
 * @Description: FastDFs参数
 * @Version 1.0.0
 * @date 2020/5/19 19:00
 */
@Configuration
@ConditionalOnProperty(prefix = "fdfs", name = "file-host")
@ConfigurationProperties(prefix = "fdfs")
public class FdfsPropertiesConfig {
    private String fileHost;

    public String getFileHost() {
        return fileHost;
    }

    public void setFileHost(String fileHost) {
        this.fileHost = fileHost;
    }
}
