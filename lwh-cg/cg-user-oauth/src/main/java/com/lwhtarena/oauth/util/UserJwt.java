package com.lwhtarena.oauth.util;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author liwh
 * @Title: UserJwt
 * @Package com.lwhtarena.oauth.util
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/17 10:00
 */
public class UserJwt extends User {

    /**用户ID**/
    private String id;
    /**用户名字**/
    private String name;
    /**设置公司**/
    private String comny;

    public UserJwt(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
