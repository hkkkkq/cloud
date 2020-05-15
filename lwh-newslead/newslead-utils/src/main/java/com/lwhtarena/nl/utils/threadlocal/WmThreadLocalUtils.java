package com.lwhtarena.nl.utils.threadlocal;

import com.lwhtarena.nl.model.media.pojos.WmUser;

/**
 * @author liwh
 * @Title: WmThreadLocalUtils
 * @Package com.lwhtarena.nl.utils.threadlocal
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 08:43
 */
public class WmThreadLocalUtils {
    private final  static ThreadLocal<WmUser> userThreadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程中的用户
     * @param user
     */
    public static void setUser(WmUser user){
        userThreadLocal.set(user);
    }

    /**
     * 获取线程中的用户
     * @return
     */
    public static WmUser getUser( ){
        return userThreadLocal.get();
    }
}
