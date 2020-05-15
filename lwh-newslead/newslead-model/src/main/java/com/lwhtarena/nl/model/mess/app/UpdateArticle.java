package com.lwhtarena.nl.model.mess.app;

import lombok.Data;

/**
 * @author liwh
 * @Title: UpdateArticle
 * @Package com.lwhtarena.nl.model.mess.app
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:23
 */
@Data
public class UpdateArticle {
    // 修改文章的字段类型
    private UpdateArticleType type;
    // 文章ID
    private Integer articleId;
    // 修改数据的增量，可为正负
    private Integer add;
    private Integer apUserId;
    private Integer behaviorId;

    public enum UpdateArticleType{
        COLLECTION,COMMENT,LIKES,VIEWS;
    }
}
