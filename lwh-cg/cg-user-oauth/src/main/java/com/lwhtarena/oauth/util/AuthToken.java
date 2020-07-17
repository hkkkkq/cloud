package com.lwhtarena.oauth.util;

import java.io.Serializable;

/**
 * @author liwh
 * @Title: AuthToken
 * @Package com.lwhtarena.oauth.util
 * @Description: 用户令牌封装
 * @Version 1.0.0
 * @date 2020/7/17 09:58
 */
public class AuthToken implements Serializable {

    /**令牌信息**/
    String accessToken;

    /** 刷新token(refresh_token) **/
    String refreshToken;

    /**jwt短令牌**/
    String jti;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }
}
