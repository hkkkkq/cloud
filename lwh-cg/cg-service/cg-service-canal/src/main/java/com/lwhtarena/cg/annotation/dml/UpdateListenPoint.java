package com.lwhtarena.cg.annotation.dml;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lwhtarena.cg.annotation.ListenPoint;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 功能描述:更新操作监听器
 * @author: 刘猛
 * @date: 2019/6/17 13:52
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ListenPoint(eventType = CanalEntry.EventType.UPDATE)
public @interface UpdateListenPoint {

    /**
     * canal 指令
     * default for all
     *
     */
    @AliasFor(annotation = ListenPoint.class)
    String destination() default "";

    /**
     * 数据库实例
     *
     */
    @AliasFor(annotation = ListenPoint.class)
    String[] schema() default {};

    /**
     * 监听的表
     * default for all
     *
     */
    @AliasFor(annotation = ListenPoint.class)
    String[] table() default {};

}
