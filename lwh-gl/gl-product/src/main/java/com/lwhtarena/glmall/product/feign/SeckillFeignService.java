package com.lwhtarena.glmall.product.feign;

import com.lwhtarena.common.utils.R;
import com.lwhtarena.glmall.product.feign.fallback.SeckillFeignServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liwh
 * @Title: SeckillFeignService
 * @Package com.lwhtarena.glmall.product.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 21:46
 */
@FeignClient(value = "gulimall-seckill",fallback = SeckillFeignServiceFallBack.class)
public interface SeckillFeignService {

    /**
     * 根据skuId查询商品是否参加秒杀活动
     * @param skuId
     * @return
     */
    @GetMapping(value = "/sku/seckill/{skuId}")
    R getSkuSeckilInfo(@PathVariable("skuId") Long skuId);

}
