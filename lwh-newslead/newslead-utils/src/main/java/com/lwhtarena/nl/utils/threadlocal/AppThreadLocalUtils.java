package com.lwhtarena.nl.utils.threadlocal;

import com.lwhtarena.nl.model.user.pojos.ApUser;

/**
 * @author liwh
 * @Title: AppThreadLocalUtils
 * @Package com.lwhtarena.nl.utils.threadlocal
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 08:40
 */
public class AppThreadLocalUtils {

    private final  static ThreadLocal<ApUser> userThreadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程中的用户
     * @param user
     */
    public static void setUser(ApUser user){
        userThreadLocal.set(user);
    }

    /**
     * 获取线程中的用户
     * @return
     */
    public static ApUser getUser( ){
        return userThreadLocal.get();
    }
}
