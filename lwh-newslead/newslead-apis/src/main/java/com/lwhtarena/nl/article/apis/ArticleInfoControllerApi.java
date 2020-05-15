package com.lwhtarena.nl.article.apis;

import com.lwhtarena.nl.model.article.dtos.ArticleInfoDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;

/**
 * @author liwh
 * @Title: ArticleInfoControllerApi
 * @Package com.lwhtarena.nl.article.apis
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 19:54
 */
public interface ArticleInfoControllerApi {

    public ResponseResult loadArticleInfo(ArticleInfoDto dto);

    ResponseResult loadArticleBehavior(ArticleInfoDto dto);

}
