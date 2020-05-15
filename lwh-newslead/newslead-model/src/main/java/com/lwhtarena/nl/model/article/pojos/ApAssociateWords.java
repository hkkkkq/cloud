package com.lwhtarena.nl.model.article.pojos;

import lombok.Data;

import java.util.Date;

/**
 * @author liwh
 * @Title: ApAssociateWords
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:48
 */
@Data
public class ApAssociateWords {
    private Integer id;
    private String associateWords;
    private Date createdTime;
}
