package com.lwhtarena.mt.service;

import com.lwhtarena.mt.entity.AppEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liwh
 * @Title: AppService
 * @Package com.lwhtarena.mt.service
 * @Description: 微信应用服务接口
 * @Version 1.0.0
 * @date 2020/5/16 21:40
 */
@Api(tags = "微信服务接口")
public interface WeiXinService{
    /**
     *  功能说明：应用服务接口
     * @return
     */
    @ApiOperation(value = "获取微信应用接口")
    @GetMapping(value = "/getApp")
    public AppEntity getApp();
}
