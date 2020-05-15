package com.lwhtarena.nl.article.apis;

import com.lwhtarena.nl.model.article.dtos.UserSearchDto;
import com.lwhtarena.nl.model.common.dtos.ResponseResult;

/**
 * @author liwh
 * @Title: ArticleSearchControllerApi
 * @Package com.lwhtarena.nl.article.apis
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 19:55
 */
public interface ArticleSearchControllerApi {
    /**
     * 查询搜索历史
     * @param dto
     * @return
     */
    public ResponseResult findUserSearch(UserSearchDto dto);

    /**
     * 删除搜索历史
     * @param dto
     * @return
     */
    public ResponseResult delUserSearch(UserSearchDto dto);

    /**
     * 清空搜索历史记录
     * @param dto
     * @return
     */
    public ResponseResult clearUserSearch(UserSearchDto dto);

    /**
     * 今日热词
     * @param dto
     * @return
     */
    public ResponseResult hotkeywords(UserSearchDto dto);

    /**
     * 联想词查询
     * @param dto
     * @return
     */
    public ResponseResult searchassociate(UserSearchDto dto);

    /**
     * es文章分页查询
     * @param dto
     * @return
     */
    public ResponseResult esArticleSearch(UserSearchDto dto);
}
