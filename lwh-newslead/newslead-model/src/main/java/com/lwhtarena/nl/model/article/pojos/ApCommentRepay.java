package com.lwhtarena.nl.model.article.pojos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author liwh
 * @Title: ApCommentRepay
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:51
 */
@Data
public class ApCommentRepay {
    private Integer id;
    private Integer authorId;
    private String authorName;
    private Integer commentId;
    private String content;
    private Integer likes;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String address;
    private Date createdTime;
    private Date updatedTime;
}
