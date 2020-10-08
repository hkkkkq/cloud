package com.lwhtarena.glmall.seckill.feign;

import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liwh
 * @Title: CouponFeignService
 * @Package com.lwhtarena.glmall.seckill.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 04:24
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    /**
     * 查询最近三天需要参加秒杀商品的信息
     * @return
     */
    @GetMapping(value = "/coupon/seckillsession/Lates3DaySession")
    R getLates3DaySession();

}
