package com.lwhtarena.glmall.order.feign;

import com.lwhtarena.glmall.order.vo.OrderItemVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author liwh
 * @Title: CartFeignService
 * @Package com.lwhtarena.glmall.order.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:42
 */
@FeignClient("gulimall-cart")
public interface CartFeignService {

    /**
     * 查询当前用户购物车选中的商品项
     * @return
     */
    @GetMapping(value = "/currentUserCartItems")
    List<OrderItemVo> getCurrentCartItems();

}
