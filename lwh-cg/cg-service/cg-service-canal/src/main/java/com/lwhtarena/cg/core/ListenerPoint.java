package com.lwhtarena.cg.core;


import com.lwhtarena.cg.annotation.ListenPoint;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:监听 canal 操作
 * @author: 刘猛
 * @date: 2019/6/17 13:55
 **/
public class ListenerPoint {
    /**
     * 目标
     */
    private Object target;
    
    /**
     * 监听的方法和节点
     */
    private Map<Method, ListenPoint> invokeMap = new HashMap<>();
    
    /**
     * 构造方法，设置目标，方法以及注解类型
     *
     * @param target 目标
     * @param method 方法
     * @param anno 注解类型
     * @return
     */
    public ListenerPoint(Object target, Method method, ListenPoint anno) {
        this.target = target;
        this.invokeMap.put(method, anno);
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    public Map<Method, ListenPoint> getInvokeMap() {
        return invokeMap;
    }

    public void setInvokeMap(Map<Method, ListenPoint> invokeMap) {
        this.invokeMap = invokeMap;
    }
}
