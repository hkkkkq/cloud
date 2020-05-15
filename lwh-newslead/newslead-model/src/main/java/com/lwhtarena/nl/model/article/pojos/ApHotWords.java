package com.lwhtarena.nl.model.article.pojos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liwh
 * @Title: ApHotWords
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:53
 */
@Data
public class ApHotWords implements Serializable {
    private Integer id;
    private String hotWords;
    private Integer type;
    private String hotDate;
    private Date createdTime;
}
