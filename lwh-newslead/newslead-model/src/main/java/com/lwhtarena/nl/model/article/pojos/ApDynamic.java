package com.lwhtarena.nl.model.article.pojos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApDynamic
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:51
 */
@Data
public class ApDynamic {
    private Integer id;
    private Integer userId;
    private String userName;
    private String content;
    private Boolean isForward;
    private Integer articleId;
    private String articelTitle;
    private String articleImage;
    private Boolean layout;
    private String images;
    private Integer likes;
    private Integer collection;
    private Integer comment;
    private Integer views;
    private Date createdTime;
}
