package com.lwhtarena.mt.util;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author liwh
 * @Title: RibbonVersionHolder
 * @Package com.lwhtarena.mt.util
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 20:10
 */
public class RibbonVersionHolder {

    private static final ThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static String getContext() {
        return context.get();
    }

    public static void setContext(String value) {
        context.set(value);
    }

    public static void clearContext() {
        context.remove();
    }
}
