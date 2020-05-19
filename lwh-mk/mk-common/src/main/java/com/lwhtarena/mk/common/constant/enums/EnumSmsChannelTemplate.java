package com.lwhtarena.mk.common.constant.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liwh
 * @Title: EnumSmsChannelTemplate
 * @Package com.lwhtarena.mk.common.constant.enums
 * @Description: 短信通道模板
 * @Version 1.0.0
 * @date 2020/5/19 17:54
 */
public enum EnumSmsChannelTemplate {
    /**
     * 登录验证
     */
    LOGIN_NAME_LOGIN("loginCodeChannel", "登录验证"),
    /**
     * 服务异常提醒
     */
    SERVICE_STATUS_CHANGE("serviceStatusChange", "Pig4Cloud");


    /**
     * 模板名称
     */
    @Getter
    @Setter
    private String template;
    /**
     * 模板签名
     */
    @Getter
    @Setter
    private String signName;

    EnumSmsChannelTemplate(String template, String signName) {
        this.template = template;
        this.signName = signName;
    }
}
