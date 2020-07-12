package com.lwhtarena.cg.annotation.ddl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lwhtarena.cg.annotation.ListenPoint;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 功能描述:刪除索引操作
 * @author: 刘猛
 * @date: 2019/6/17 13:53
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ListenPoint(eventType = CanalEntry.EventType.DINDEX)
public @interface DropIndexListenPoint {
	/**
	 * canal 指令
	 * default for all
	 *
	 * @return canal destination
	 */
	@AliasFor(annotation = ListenPoint.class)
	String destination() default "";
	
	/**
	 * 数据库实例
	 *
	 * @return canal destination
	 */
	@AliasFor(annotation = ListenPoint.class)
	String[] schema() default {};
	
	/**
	 * 监听的表
	 * default for all
	 *
	 * @return canal destination
	 */
	@AliasFor(annotation = ListenPoint.class)
	String[] table() default {};
}
