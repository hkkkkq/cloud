package com.lwhtarena.glmall.order.feign;

import com.lwhtarena.glmall.order.vo.MemberAddressVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author liwh
 * @Title: MemberFeignService
 * @Package com.lwhtarena.glmall.order.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:43
 */

@FeignClient("gulimall-member")
public interface MemberFeignService {

    /**
     * 查询当前用户的全部收货地址
     * @param memberId
     * @return
     */
    @GetMapping(value = "/member/memberreceiveaddress/{memberId}/address")
    List<MemberAddressVo> getAddress(@PathVariable("memberId") Long memberId);
}
