package com.lwhtarena.glmall.ware.feign;

import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author liwh
 * @Title: OrderFeignService
 * @Package com.lwhtarena.glmall.ware.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 23:27
 */
@FeignClient("gulimall-order")
public interface OrderFeignService {

    @GetMapping(value = "/order/order/status/{orderSn}")
    R getOrderStatus(@PathVariable("orderSn") String orderSn);

}
