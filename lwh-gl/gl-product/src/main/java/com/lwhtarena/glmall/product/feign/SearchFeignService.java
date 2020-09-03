package com.lwhtarena.glmall.product.feign;

import com.lwhtarena.common.es.SkuEsModel;
import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author liwh
 * @Title: SearchFeignService
 * @Package com.lwhtarena.glmall.product.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 21:45
 */
@FeignClient("gulimall-search")
public interface SearchFeignService {

    @PostMapping(value = "/search/save/product")
    public R productStatusUp(@RequestBody List<SkuEsModel> skuEsModels);
}
