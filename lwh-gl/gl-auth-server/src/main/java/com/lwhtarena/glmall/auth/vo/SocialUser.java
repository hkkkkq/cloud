package com.lwhtarena.glmall.auth.vo;

import lombok.Data;

/**
 * @author liwh
 * @Title: SocialUser
 * @Package com.lwhtarena.glmall.auth.vo
 * @Description: 社交用户信息
 * @Version 1.0.0
 * @date 2020/9/29 16:46
 */
@Data
public class SocialUser {

    private String access_token;

    private String remind_in;

    private long expires_in;

    private String uid;

    private String isRealName;

}
