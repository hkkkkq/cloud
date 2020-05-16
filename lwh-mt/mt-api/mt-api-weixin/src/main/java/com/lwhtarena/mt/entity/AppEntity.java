package com.lwhtarena.mt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author liwh
 * @Title: AppEntity
 * @Package com.lwhtarena.mt.entity
 * @Description: 应用实体
 * @Version 1.0.0
 * @date 2020/5/16 21:37
 */
@Data
@AllArgsConstructor
public class AppEntity {
    /**
     * 应用ID
     */
    private String appId;

    /**
     * 应用秘钥
     */
    private String appSecret;
}
