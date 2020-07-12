package com.lwhtarena.cg.config;

import com.lwhtarena.cg.client.SimpleCanalClient;
import com.lwhtarena.cg.properties.CanalProperties;
import com.lwhtarena.cg.util.BeanCovertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author liwh
 * @Title: CanalClientConfiguration
 * @Package com.lwhtarena.cg.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/12 15:22
 */
public class CanalClientConfiguration {
    /**
     * 记录日志
     */
    private final static Logger logger = LoggerFactory.getLogger(CanalClientConfiguration.class);

    /**
     * canal 配置
     */
    @Autowired
    private CanalProperties canalProperties;

    /**
     * 返回 bean 工具类
     *
     * @param
     * @return
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public BeanCovertUtil beanUtil() {
        return new BeanCovertUtil();
    }

    /**
     * 返回 canal 的客户端
     *
     */
    @Bean
    private SimpleCanalClient canalClient() {
        logger.info("正在尝试连接 canal 客户端....");
        //连接 canal 客户端
//        CanalClient canalClient = new SimpleCanalClient(canalConfig, MessageTransponders.defaultMessageTransponder());
        SimpleCanalClient canalClient = new SimpleCanalClient(canalProperties);
        logger.info("正在尝试开启 canal 客户端....");
        //开启 canal 客户端
        canalClient.start();
        logger.info("启动 canal 客户端成功....");
        //返回结果
        return canalClient;
    }
}
