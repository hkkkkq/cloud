package com.lwhtarena.glmall.auth.feign;

import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liwh
 * @Title: ThirdPartFeignService
 * @Package com.lwhtarena.glmall.auth.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 03:11
 */
@FeignClient("gulimall-third-party")
public interface ThirdPartFeignService {

    @GetMapping(value = "/sms/sendCode")
    R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code);

}
