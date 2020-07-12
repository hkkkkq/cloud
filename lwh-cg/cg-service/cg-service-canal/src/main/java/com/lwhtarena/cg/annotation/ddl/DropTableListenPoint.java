package com.lwhtarena.cg.annotation.ddl;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.lwhtarena.cg.annotation.ListenPoint;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 功能描述:刪除表操作監聽器
 * @author: 刘猛
 * @date: 2019/6/17 13:53
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ListenPoint(eventType = CanalEntry.EventType.ERASE)
public @interface DropTableListenPoint {
	/**
	 * canal 指令
	 * default for all
	 *
	 * @return canal destination
	 * @author 阿导
	 * @time 2018/5/28 15:49
	 * @CopyRight 万物皆导
	 */
	@AliasFor(annotation = ListenPoint.class)
	String destination() default "";
	
	/**
	 * 数据库实例
	 *
	 * @return canal destination
	 * @author 阿导
	 * @time 2018/5/28 15:49
	 * @CopyRight 万物皆导
	 */
	@AliasFor(annotation = ListenPoint.class)
	String[] schema() default {};
}
