package com.lwhtarena.mk.common.bean.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwh
 * @Title: FilterIgnorePropertiesConfig
 * @Package com.lwhtarena.mk.common.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 19:01
 */
@Data
@Configuration
@RefreshScope
@ConditionalOnExpression("!'${ignore}'.isEmpty()")
@ConfigurationProperties(prefix = "ignore")
public class FilterIgnorePropertiesConfig {

    private List<String> urls = new ArrayList<>();

    private List<String> clients = new ArrayList<>();
}
