package com.lwhtarena.nl.utils.threadlocal;

import com.lwhtarena.nl.model.admin.pojos.AdUser;

/**
 * @author liwh
 * @Title: AdminThreadLocalUtils
 * @Package com.lwhtarena.nl.utils.threadlocal
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 08:36
 */
public class AdminThreadLocalUtils {
    private final  static ThreadLocal<AdUser> userThreadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程中的用户
     * @param user
     */
    public static void setUser(AdUser user){
        userThreadLocal.set(user);
    }

    /**
     * 获取线程中的用户
     * @return
     */
    public static AdUser getUser( ){
        return userThreadLocal.get();
    }
}
