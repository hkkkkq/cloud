package com.lwhtarena.nl.model.article.pojos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liwh
 * @Title: ApComment
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:50
 */
@Data
public class ApComment {
    private Integer id;
    private Integer authorId;
    private String authorName;
    private Integer entryId;
    private Integer channelId;
    private Boolean type;
    private String content;
    private String image;
    private Integer likes;
    private Integer reply;
    private Byte flag;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String address;
    private Integer ord;
    private Date createdTime;
    private Date updatedTime;
}
