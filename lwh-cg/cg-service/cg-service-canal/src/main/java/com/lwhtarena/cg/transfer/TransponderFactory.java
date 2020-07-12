package com.lwhtarena.cg.transfer;

import com.alibaba.otter.canal.client.CanalConnector;
import com.lwhtarena.cg.annotation.CanalEventListener;
import com.lwhtarena.cg.core.ListenerPoint;
import com.lwhtarena.cg.properties.CanalProperties;


import java.util.List;
import java.util.Map;

/**
 * @Description 信息转换工厂类接口层
 * @see <url>https://gitee.com/cowboy2016/springboot2-open/tree/master/open-db/open-db-canal</url>
 * @author: 刘猛
 * @date: 2019/6/17 13:45
 **/
@FunctionalInterface
public interface TransponderFactory {
	
	/**
	 * @param connector        canal 连接工具
	 * @param config           canal 链接信息
	 * @param listeners 实现接口的监听器
	 * @param annoListeners    注解监听拦截
	 * @return
	 * @author 阿导
	 * @time 2018/5/28 14:43
	 * @CopyRight 万物皆导
	 */
	MessageTransponder newTransponder(CanalConnector connector, Map.Entry<String, CanalProperties.Instance> config, List<CanalEventListener> listeners, List<ListenerPoint> annoListeners);
}
