package com.lwhtarena.glmall.seckill.feign;

import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liwh
 * @Title: ProductFeignService
 * @Package com.lwhtarena.glmall.seckill.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 04:25
 */
@FeignClient("gulimall-product")
public interface ProductFeignService {

    @RequestMapping("/product/skuinfo/info/{skuId}")
    R getSkuInfo(@PathVariable("skuId") Long skuId);

}
