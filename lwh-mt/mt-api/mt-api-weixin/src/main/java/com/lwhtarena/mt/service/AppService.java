package com.lwhtarena.mt.service;

import com.lwhtarena.mt.entity.AppEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liwh
 * @Title: AppService
 * @Package com.lwhtarena.mt.service
 * @Description: 微信应用服务接口
 * @Version 1.0.0
 * @date 2020/5/16 21:40
 */
public interface AppService {

    @GetMapping(value = "/getApp")
    public AppEntity getApp();
}
