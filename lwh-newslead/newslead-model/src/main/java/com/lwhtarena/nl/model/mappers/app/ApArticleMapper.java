package com.lwhtarena.nl.model.mappers.app;

import com.lwhtarena.nl.model.article.dtos.ArticleHomeDto;
import com.lwhtarena.nl.model.article.pojos.ApArticle;
import com.lwhtarena.nl.model.user.pojos.ApUserArticleList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liwh
 * @Title: ApArticleMapper
 * @Package com.lwhtarena.nl.model.mappers.app
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 20:35
 */
public interface ApArticleMapper {

    List<ApArticle> loadArticleListByLocation(@Param("dto") ArticleHomeDto dto, @Param("type") Short type);

    List<ApArticle> loadArticleListByIdList(List<ApUserArticleList> list);

    ApArticle selectById(Long id);

    void insert(ApArticle apArticle);

    List<ApArticle> loadLastArticleForHot(String lastDay);

    /**
     * 更新文章数
     * @param articleId
     * @param viewCount
     * @param collectCount
     * @param commontCount
     * @param likeCount
     * @return
     */
    int updateArticleView(@Param("articleId") Integer articleId, @Param("viewCount") long viewCount,@Param("collectCount") long collectCount,@Param("commontCount") long commontCount,@Param("likeCount") long likeCount);

    /**
     * 依据文章IDS来获取文章详细内容
     * @param list 文章ID
     * @return
     */
    List<ApArticle> loadArticleListByIdListV2(List<Integer> list);

    /**
     * 查询
     *
     * @param apArticle
     * @return
     */
    List<ApArticle> selectList(ApArticle apArticle);
    /**
     * 更新
     * @param apArticle
     */
    void updateSyncStatus(ApArticle apArticle);
}
