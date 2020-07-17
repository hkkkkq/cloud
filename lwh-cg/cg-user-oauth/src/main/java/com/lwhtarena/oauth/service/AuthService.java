package com.lwhtarena.oauth.service;

import com.lwhtarena.oauth.util.AuthToken;

/**
 * @author liwh
 * @Title: AuthService
 * @Package com.lwhtarena.oauth.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/17 10:03
 */
public interface AuthService {
    /***
     * 授权认证方法
     */
    AuthToken login(String username, String password, String clientId, String clientSecret);
}
