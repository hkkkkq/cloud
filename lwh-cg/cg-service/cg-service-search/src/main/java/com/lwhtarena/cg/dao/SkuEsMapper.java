package com.lwhtarena.cg.dao;

import com.lwhtarena.cg.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author liwh
 * @Title: SkuEsMappe
 * @Package com.lwhtarena.cg.dao
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/13 21:16
 */
public interface SkuEsMapper extends ElasticsearchRepository<SkuInfo,Long> {
}