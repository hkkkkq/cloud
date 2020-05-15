package com.lwhtarena.nl.model.article.pojos;

import com.lwhtarena.nl.model.annotation.DateConvert;
import com.lwhtarena.nl.model.annotation.IdEncrypt;
import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApArticle
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 19:49
 */
@Data
public class ApArticle {
    private Integer id;
    private String title;
    @IdEncrypt
    private Long authorId;
    private String authorName;
    @IdEncrypt
    private Integer channelId;
    private String channelName;
    private Short layout;
    private Byte flag;
    private String images;
    private String labels;
    private Integer likes;
    private Integer collection;
    private Integer comment;
    private Integer views;
    private Integer provinceId;
    private Integer cityId;
    private Integer countyId;
    @DateConvert("yyyyMMddHHmmss")
    private Date createdTime;
    @DateConvert("yyyyMMddHHmmss")
    private Date publishTime;
    private Boolean syncStatus;
    private Boolean origin;
}
