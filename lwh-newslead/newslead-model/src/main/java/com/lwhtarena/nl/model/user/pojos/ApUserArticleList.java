package com.lwhtarena.nl.model.user.pojos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApUserArticleList
 * @Package com.lwhtarena.nl.model.user.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:31
 */
@Data
public class ApUserArticleList {
    private Integer id;
    private Integer userId;
    private Integer channelId;
    private Integer articleId;
    private Boolean isShow;
    private Date recommendTime;
    private Boolean isRead;
    private Integer strategyId;
}
