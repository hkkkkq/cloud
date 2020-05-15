package com.lwhtarena.nl.article.controller.v1;

import com.lwhtarena.nl.article.apis.ArticleHomeControllerApi;
import com.lwhtarena.nl.article.service.AppArticleService;
import com.lwhtarena.nl.common.article.constans.ArticleConstans;
import com.lwhtarena.nl.model.article.dtos.ArticleHomeDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwh
 * @Title: ArticleHomeController
 * @Package com.lwhtarena.nl.article.controller.v1
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:08
 */

@RestController
@RequestMapping("/api/v1/article")
public class ArticleHomeController implements ArticleHomeControllerApi {

    @Autowired
    private AppArticleService appArticleService;

    @Override
    @PostMapping("/load")
    public ResponseResult load(ArticleHomeDto dto) {
        return appArticleService.load(dto, ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    @PostMapping("/loadmore")
    public ResponseResult loadMore(ArticleHomeDto dto) {
        return appArticleService.load(dto,ArticleConstans.LOADTYPE_LOAD_MORE);
    }

    @Override
    @PostMapping("/loadnew")
    public ResponseResult loadNew(ArticleHomeDto dto) {
        return appArticleService.load(dto,ArticleConstans.LOADTYPE_LOAD_NEW);
    }
}
