package com.lwhtarena.glmall.product.feign.fallback;

import com.lwhtarena.common.exception.BizCodeEnume;
import com.lwhtarena.common.utils.R;
import com.lwhtarena.glmall.product.feign.SeckillFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author liwh
 * @Title: SeckillFeignServiceFallBack
 * @Package com.lwhtarena.glmall.product.feign.fallback
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/21 22:25
 */
@Slf4j
@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        log.info("熔断方法调用...getSkuSeckilInfo");
        return R.error(BizCodeEnume.TO_MANY_REQUEST.getCode(),BizCodeEnume.TO_MANY_REQUEST.getMsg());
    }
}
