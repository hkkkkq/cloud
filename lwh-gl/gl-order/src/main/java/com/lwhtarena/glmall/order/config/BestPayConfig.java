package com.lwhtarena.glmall.order.config;

import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.BestPayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liwh
 * @Title: BestPayConfig
 * @Package com.lwhtarena.glmall.order.config
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:51
 */
@Component
public class BestPayConfig {

    @Resource
    private WxAccountConfig wxAccountConfig;

    @Bean
    public BestPayService bestPayService() {
        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig());
        return bestPayService;
    }

    @Bean
    public WxPayConfig wxPayConfig() {
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(wxAccountConfig.getAppId());
        wxPayConfig.setMchId(wxAccountConfig.getMchId());
        wxPayConfig.setMchKey(wxAccountConfig.getMchKey());
        //192.168.50.101 同一局域网可访问
        //125.121.56.227 云服务器可行，家庭宽带不行(路由器、光猫)
        wxPayConfig.setNotifyUrl(wxAccountConfig.getNotifyUrl());
        wxPayConfig.setReturnUrl(wxAccountConfig.getReturnUrl());
        return wxPayConfig;
    }

}
