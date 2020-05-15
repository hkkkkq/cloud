package com.lwhtarena.nl.model.article.pojos;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liwh
 * @Title: ApArticleLabel
 * @Package com.lwhtarena.nl.model.article.pojos
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:47
 */
@Getter
@Setter
public class ApArticleLabel {
    private Integer id;

    private Integer articleId;

    private Integer labelId;

    private Integer count;

    public ApArticleLabel() {
    }

    public ApArticleLabel(Integer articleId, Integer labelId) {
        this.articleId = articleId;
        this.labelId = labelId;
    }
}
