package com.lwhtarena.nl.model.admin.pojos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: AdUser
 * @Package com.lwhtarena.nl.model.admin.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 08:37
 */
@Data
public class AdUser {
    private Long id;
    private String name;
    private String password;
    private String salt;
    private String nickname;
    private String image;
    private String phone;
    private Short status;
    private String email;
    private Date loginTime;
    private Date createdTime;
}
