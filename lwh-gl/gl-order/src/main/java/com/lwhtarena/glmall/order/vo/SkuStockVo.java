package com.lwhtarena.glmall.order.vo;

import lombok.Data;

/**
 * @author liwh
 * @Title: SkuStockVo
 * @Package com.lwhtarena.glmall.order.vo
 * @Description: 库存vo
 * @Version 1.0.0
 * @date 2020/9/9 16:20
 */

@Data
public class SkuStockVo {
    private Long skuId;
    private Boolean hasStock;
}