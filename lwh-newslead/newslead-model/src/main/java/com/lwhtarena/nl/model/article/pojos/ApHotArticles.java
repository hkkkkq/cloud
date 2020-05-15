package com.lwhtarena.nl.model.article.pojos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApHotArticles
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:45
 */
@Data
public class ApHotArticles {
    private Integer id;
    private Integer entryId;
    private Integer tagId;
    private String tagName;
    private Integer score;
    private Integer articleId;
    private Date releaseDate;
    private Date createdTime;
    private Integer provinceId;
    private Integer cityId;
    private Integer countyId;
    private Integer isRead;
}
