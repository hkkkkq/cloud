package com.lwhtarena.cg.service;

import java.util.Map;

/**
 * @author liwh
 * @Title: SkuService
 * @Package com.lwhtarena.cg.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/13 21:17
 */
public interface SkuService {

    /**
     * 1.调用 goods微服务的fegin 查询 符合条件的sku的数据
     * 2.调用spring data elasticsearch的API 导入到ES中
     */
    void  importEs();


    /**
     * 搜索
     * @param searchMap
     * @return
     */
    Map search(Map<String,String> searchMap);
}
