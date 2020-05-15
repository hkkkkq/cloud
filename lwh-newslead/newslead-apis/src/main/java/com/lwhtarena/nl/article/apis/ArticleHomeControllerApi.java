package com.lwhtarena.nl.article.apis;

import com.lwhtarena.nl.model.article.dtos.ArticleHomeDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;

/**
 * @author liwh
 * @Title: ArticleHomeControllerApi
 * @Package com.lwhtarena.nl.article.apis
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 19:54
 */
public interface ArticleHomeControllerApi {
    /**
     * 加载首页文章
     * @param dto
     * @return
     */
    public ResponseResult load(ArticleHomeDto dto);

    /**
     * 加载更多
     * @param dot
     * @return
     */
    public ResponseResult loadMore(ArticleHomeDto dot);

    /**
     * 加载最新的文章信息
     * @param dto
     * @return
     */
    public ResponseResult loadNew(ArticleHomeDto dto);
}
