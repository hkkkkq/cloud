package com.lwhtarena.cg.annotation;

import com.lwhtarena.cg.config.CanalClientConfiguration;
import com.lwhtarena.cg.properties.CanalProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author liwh
 * @Title: EnableCanalClient
 * @Package com.lwhtarena.cg.annotation
 * @Description: 开启 Canal 客户端
 * @Version 1.0.0
 * @date 2020/7/12 14:54
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({CanalProperties.class, CanalClientConfiguration.class})
public @interface EnableCanalClient {
}
