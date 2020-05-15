package com.lwhtarena.nl.model.user.pojos;

import lombok.Data;

/**
 * @author liwh
 * @Title: ApUser
 * @Package com.lwhtarena.nl.model.user.pojos
 * @Description: app用户
 * @Version 1.0.0
 * @date 2020/5/15 08:42
 */
@Data
public class ApUser {
    private Long id;
    private String salt;
    private String name;
    private String password;
    private String phone;
    private String image;
    private Boolean sex;
    private Boolean isCertification;
    private Boolean isIdentityAuthentication;
    private Boolean status;
    private int flag;
}
