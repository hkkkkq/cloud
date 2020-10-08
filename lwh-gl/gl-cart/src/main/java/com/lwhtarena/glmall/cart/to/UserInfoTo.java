package com.lwhtarena.glmall.cart.to;

import lombok.Data;

/**
 * @author liwh
 * @Title: UserInfoTo
 * @Package com.lwhtarena.glmall.cart.to
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 03:41
 */
@Data
public class UserInfoTo {

    private Long userId;

    private String userKey;

    /**
     * 是否临时用户
     */
    private Boolean tempUser = false;

}
