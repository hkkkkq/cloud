package com.lwhtarena.glmall.seckill.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liwh
 * @Title: SeckillSkuVo
 * @Package com.lwhtarena.glmall.seckill.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 04:11
 */
@Data
public class SeckillSkuVo {

    private Long id;
    /**
     * 活动id
     */
    private Long promotionId;
    /**
     * 活动场次id
     */
    private Long promotionSessionId;
    /**
     * 商品id
     */
    private Long skuId;
    /**
     * 秒杀价格
     */
    private BigDecimal seckillPrice;
    /**
     * 秒杀总量
     */
    private Integer seckillCount;
    /**
     * 每人限购数量
     */
    private Integer seckillLimit;
    /**
     * 排序
     */
    private Integer seckillSort;

}