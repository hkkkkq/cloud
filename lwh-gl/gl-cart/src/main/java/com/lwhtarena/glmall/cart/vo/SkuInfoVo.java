package com.lwhtarena.glmall.cart.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liwh
 * @Title: SkuInfoVo
 * @Package com.lwhtarena.glmall.cart.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/10/9 03:39
 */
@Data
public class SkuInfoVo {

    private Long skuId;
    /**
     * spuId
     */
    private Long spuId;
    /**
     * sku名称
     */
    private String skuName;
    /**
     * sku介绍描述
     */
    private String skuDesc;
    /**
     * 所属分类id
     */
    private Long catalogId;
    /**
     * 品牌id
     */
    private Long brandId;
    /**
     * 默认图片
     */
    private String skuDefaultImg;
    /**
     * 标题
     */
    private String skuTitle;
    /**
     * 副标题
     */
    private String skuSubtitle;
    /**
     * 价格
     */
    private BigDecimal price;
    /**
     * 销量
     */
    private Long saleCount;

}
