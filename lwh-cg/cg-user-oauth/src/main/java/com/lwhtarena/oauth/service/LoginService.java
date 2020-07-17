package com.lwhtarena.oauth.service;

import com.lwhtarena.oauth.util.AuthToken;

/**
 * @author liwh
 * @Title: LoginService
 * @Package com.lwhtarena.oauth.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/17 10:04
 */
public interface LoginService {
    /**
     * 模拟用户的行为 发送请求 申请令牌 返回
     * @param username
     * @param password
     * @param clientId
     * @param clientSecret
     * @param grandType
     * @return
     */
    AuthToken login(String username, String password, String clientId, String clientSecret, String grandType);
}
