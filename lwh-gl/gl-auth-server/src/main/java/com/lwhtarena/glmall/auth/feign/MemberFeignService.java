package com.lwhtarena.glmall.auth.feign;

import com.lwhtarena.common.utils.R;
import com.lwhtarena.glmall.auth.vo.SocialUser;
import com.lwhtarena.glmall.auth.vo.UserLoginVo;
import com.lwhtarena.glmall.auth.vo.UserRegisterVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liwh
 * @Title: MemberFeignService
 * @Package com.lwhtarena.glmall.auth.feign
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 03:14
 */
@FeignClient("gulimall-member")
public interface MemberFeignService {

    @PostMapping(value = "/member/member/register")
    R register(@RequestBody UserRegisterVo vo);


    @PostMapping(value = "/member/member/login")
    R login(@RequestBody UserLoginVo vo);

    @PostMapping(value = "/member/member/oauth2/login")
    R oauthLogin(@RequestBody SocialUser socialUser) throws Exception;

    @PostMapping(value = "/member/member/weixin/login")
    R weixinLogin(@RequestParam("accessTokenInfo") String accessTokenInfo);
}
