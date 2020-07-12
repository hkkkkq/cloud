package com.lwhtarena.cg.annotation;

import com.alibaba.otter.canal.protocol.CanalEntry;
import java.lang.annotation.*;

/**
 * @author liwh
 * @Title: ListenPoint
 * @Package com.lwhtarena.cg.annotation
 * @Description: 功能描述:监听数据库的操作
 * @Version 1.0.0
 * @date 2020/7/12 15:15
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ListenPoint {
    /**
     * canal 指令
     */
    String destination() default "";

    /**
     * 数据库实例
     */
    String[] schema() default {};

    /**
     * 监听的表
     */
    String[] table() default {};

    /**
     * 监听操作的类型
     */
    CanalEntry.EventType[] eventType() default {};
}
