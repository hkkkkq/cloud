package com.lwhtarena.nl.article.service;

import com.lwhtarena.nl.model.article.dtos.ArticleHomeDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;
import com.lwhtarena.nl.model.mess.app.ArticleVisitStreamDto;

/**
 * @author liwh
 * @Title: AppArticleService
 * @Package com.lwhtarena.nl.article.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:11
 */
public interface AppArticleService {
    /**
     * type  1 加载更多  2 加载更新
     * @param dto
     * @param type
     * @return
     */
    ResponseResult load(ArticleHomeDto dto, Short type);

    /**
     * 更新 点赞 阅读数
     * @param dto
     * @return
     */
    ResponseResult updateArticleView(ArticleVisitStreamDto dto);

    /**
     * 加载文章列表数据
     * @param type
     * @param dto
     * @param firstPage
     * @return
     */
    ResponseResult loadV2(Short type,ArticleHomeDto dto,boolean firstPage);
}
