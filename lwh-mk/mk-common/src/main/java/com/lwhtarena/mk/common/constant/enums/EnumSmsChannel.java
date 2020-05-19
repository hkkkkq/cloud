package com.lwhtarena.mk.common.constant.enums;

/**
 * @author liwh
 * @Title: EnumSmsChannel
 * @Package com.lwhtarena.mk.common.constant.enums
 * @Description: 短信通道枚举
 * @Version 1.0.0
 * @date 2020/5/19 17:53
 */
public enum EnumSmsChannel {
    /**
     * 阿里大鱼短信通道
     */
    ALIYUN("ALIYUN_SMS", "阿里大鱼");
    /**
     * 通道名称
     */
    private String name;
    /**
     * 通道描述
     */
    private String description;

    EnumSmsChannel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
