package com.lwhtarena.mt.service;

import com.lwhtarena.mt.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author liwh
 * @Title: MemberService
 * @Package com.lwhtarena.mt.service
 * @Description: 会员服务接口
 * @Version 1.0.0
 * @date 2020/5/16 23:17
 */

@Api(tags = "会员服务接口")
public interface MemberService {

    /**
     * 会员服务接口调用微信接口
     * @return
     */
    @ApiOperation(value = "会员调用微信服务接口")
    public AppEntity memberInvokeWeiXin();
}
