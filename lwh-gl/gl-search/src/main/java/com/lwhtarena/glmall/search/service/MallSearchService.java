package com.lwhtarena.glmall.search.service;

import com.lwhtarena.glmall.search.vo.SearchParam;
import com.lwhtarena.glmall.search.vo.SearchResult;

/**
 * @author liwh
 * @Title: MallSearchService
 * @Package com.lwhtarena.glmall.search.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/4 16:06
 */
public interface MallSearchService {

    /**
     * @param param 检索的所有参数
     * @return  返回检索的结果，里面包含页面需要的所有信息
     */
    SearchResult search(SearchParam param);
}
