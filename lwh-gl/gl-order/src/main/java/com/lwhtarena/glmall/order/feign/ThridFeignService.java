package com.lwhtarena.glmall.order.feign;

import com.alipay.api.AlipayApiException;
import com.lwhtarena.glmall.order.vo.PayVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author liwh
 * @Title: ThridFeignService
 * @Package com.lwhtarena.glmall.order.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:44
 */
@FeignClient("gulimall-third-party")
public interface ThridFeignService {

    @GetMapping(value = "/pay",consumes = "application/json")
    String pay(@RequestBody PayVo vo) throws AlipayApiException;

}
