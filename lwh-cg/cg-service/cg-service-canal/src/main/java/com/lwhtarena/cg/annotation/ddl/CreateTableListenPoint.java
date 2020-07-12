package com.lwhtarena.cg.annotation.ddl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lwhtarena.cg.annotation.ListenPoint;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 功能描述:表结构发生变化，新增时，先判断数据库实例是否存在，不存在则创建
 * @author: 刘猛
 * @date: 2019/6/17 13:52
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ListenPoint(eventType = CanalEntry.EventType.CREATE)
public @interface CreateTableListenPoint {
	
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
}
