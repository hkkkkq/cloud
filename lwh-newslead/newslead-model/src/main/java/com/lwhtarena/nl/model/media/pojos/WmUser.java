package com.lwhtarena.nl.model.media.pojos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: WmUser
 * @Package com.lwhtarena.nl.model.media.pojos
 * @Description: 微信用户
 * @Version 1.0.0
 * @date 2020/5/15 08:44
 */

@Data
public class WmUser {
    private Long id;
    private String name;
    private String password;
    private String salt;
    private String nickname;
    private String image;
    private String location;
    private String phone;
    private Integer status;
    private String email;
    private Integer type;
    private Integer score;
    private Long apUserId;
    private Integer apAuthorId;
    private Date loginTime;
    private Date createdTime;
}
