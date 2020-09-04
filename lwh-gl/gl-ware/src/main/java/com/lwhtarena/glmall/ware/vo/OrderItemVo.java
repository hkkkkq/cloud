package com.lwhtarena.glmall.ware.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liwh
 * @Title: OrderItemVo
 * @Package com.lwhtarena.glmall.ware.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 23:18
 */
@Data
public class OrderItemVo {

    private Long skuId;

    private Boolean check;

    private String title;

    private String image;

    /**
     * 商品套餐属性
     */
    private List<String> skuAttrValues;

    private BigDecimal price;

    private Integer count;

    private BigDecimal totalPrice;

    /** 商品重量 **/
    private BigDecimal weight = new BigDecimal("0.085");
}
