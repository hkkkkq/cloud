package com.lwhtarena.nl.model.mappers.app;

import com.lwhtarena.nl.model.article.dtos.ArticleHomeDto;
import com.lwhtarena.nl.model.user.pojos.ApUser;
import com.lwhtarena.nl.model.user.pojos.ApUserArticleList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liwh
 * @Title: ApUserArticleListMapper
 * @Package com.lwhtarena.nl.model.mappers.app
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:38
 */
public interface ApUserArticleListMapper {
    List<ApUserArticleList> loadArticleIdListByUser(@Param("user") ApUser user, @Param("dto") ArticleHomeDto dto, @Param("type") Short type);
}
