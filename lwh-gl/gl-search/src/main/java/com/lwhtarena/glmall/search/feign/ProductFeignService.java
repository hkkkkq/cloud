package com.lwhtarena.glmall.search.feign;

import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liwh
 * @Title: ProductFeignService
 * @Package com.lwhtarena.glmall.search.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/4 16:14
 */

@FeignClient("gulimall-product")
public interface ProductFeignService {

    @GetMapping("/product/attr/info/{attrId}")
    public R attrInfo(@PathVariable("attrId") Long attrId);

}
