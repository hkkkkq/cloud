package com.lwhtarena.glmall.seckill.service;

import com.lwhtarena.glmall.seckill.to.SeckillSkuRedisTo;

import java.util.List;

/**
 * @author liwh
 * @Title: SeckillService
 * @Package com.lwhtarena.glmall.seckill.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 04:14
 */
public interface SeckillService {

    /**
     * 上架三天需要秒杀的商品
     */
    void uploadSeckillSkuLatest3Days();

    List<SeckillSkuRedisTo> getCurrentSeckillSkus();

    /**
     * 根据skuId查询商品是否参加秒杀活动
     * @param skuId
     * @return
     */
    SeckillSkuRedisTo getSkuSeckilInfo(Long skuId);

    /**
     * 当前商品进行秒杀（秒杀开始）
     * @param killId
     * @param key
     * @param num
     * @return
     */
    String kill(String killId, String key, Integer num) throws InterruptedException;
}
