package com.lwhtarena.nl.model.mess.app;

import lombok.Data;

/**
 * @author liwh
 * @Title: ArticleVisitStreamDto
 * @Package com.lwhtarena.nl.model.mess.app
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:22
 */
@Data
public class ArticleVisitStreamDto {
    private Integer articleId;
    private long view;
    private long collect;
    private long commont;
    private long like;
}
