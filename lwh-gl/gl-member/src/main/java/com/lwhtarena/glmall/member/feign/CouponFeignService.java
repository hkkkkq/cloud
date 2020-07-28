package com.lwhtarena.glmall.member.feign;

import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liwh
 * @Title: CouponFeignService
 * @Package com.lwhtarena.glmall.member.feign
 * @Description: 这是一个声明式的远程调用
 * @Version 1.0.0
 * @date 2020/7/25 13:47
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    @RequestMapping("/coupon/coupon/member/list")
    public R membercoupons();

}
