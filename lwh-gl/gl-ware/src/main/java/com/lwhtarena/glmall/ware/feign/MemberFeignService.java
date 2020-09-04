package com.lwhtarena.glmall.ware.feign;

import com.lwhtarena.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author liwh
 * @Title: MemberFeignService
 * @Package com.lwhtarena.glmall.ware.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 23:28
 */
@FeignClient("gulimall-member")
public interface MemberFeignService {

    /**
     * 根据id获取用户地址信息
     * @param id
     * @return
     */
    @RequestMapping("/member/memberreceiveaddress/info/{id}")
    R info(@PathVariable("id") Long id);

}
