package com.lwhtarena.mt.weixin.controller;

import com.lwhtarena.mt.entity.AppEntity;
import com.lwhtarena.mt.service.WeiXinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liwh
 * @Title: WeiXinController
 * @Package com.lwhtarena.mt.weixin.service
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/16 23:02
 */
@RestController
public class WeiXinController implements WeiXinService {


    @GetMapping(value = "/getApp")
    @Override
    public AppEntity getApp() {
        return new AppEntity("123214214","测试微信");
    }
}
