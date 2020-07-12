package com.lwhtarena.cg.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description bean 工具类
 * @see <url>https://gitee.com/cowboy2016/springboot2-open/tree/master/open-db/open-db-canal</url>
 * @author: 刘猛
 * @date: 2019/6/17 13:45
 **/
@Component
public class BeanCovertUtil implements ApplicationContextAware {
	/**
	 * 上下文
	 */
	private static ApplicationContext applicationContext;
	
	/**
	 * 默认构造方法，注入上下文
	 *
	 * @param applicationContext
	 * @return
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		BeanCovertUtil.applicationContext=applicationContext;
	}
	
	/**
	 * 获取 bean
	 *
	 * @param clazz
	 * @return
	 */
	
	public static <T> T getBean(Class<T> clazz) {
		T obj;
		try {
			//从上下文获取 bean
			obj = applicationContext.getBean(clazz);
		} catch (Exception e) {
			obj = null;
		}
		//返回 bean
		return obj;
	}
	
	/**
	 * 获取 bean 的类型
	 *
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> getBeansOfType(Class<T> clazz) {
		//声明一个结果
		Map<String, T> map;
		try {
			//获取类型
			map = applicationContext.getBeansOfType(clazz);
		} catch (Exception e) {
			map = null;
		}
		//返回 bean 的类型
		return map == null ? null : new ArrayList<>(map.values());
	}
	
	
	/**
	 * 获取所有被注解的 bean
	 *
	 * @param anno
	 * @return
	 */
	public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> anno) {
		Map<String, Object> map;
		try {
			//获取注解的 bean
			map = applicationContext.getBeansWithAnnotation(anno);
		} catch (Exception e) {
			map = null;
		}
		return map;
	}
}
