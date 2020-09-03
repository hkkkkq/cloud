package com.lwhtarena.glmall.product.feign;

import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author liwh
 * @Title: WareFeignService
 * @Package com.lwhtarena.glmall.product.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 21:44
 */
@FeignClient("gulimall-ware")
public interface WareFeignService {

    @PostMapping(value = "/ware/waresku/hasStock")
    R getSkuHasStock(@RequestBody List<Long> skuIds);
}
