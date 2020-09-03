package com.lwhtarena.common.to;

import lombok.Data;

/**
 * @author liwh
 * @Title: SkuHasStockVo
 * @Package com.lwhtarena.common.to
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 22:11
 */
@Data
public class SkuHasStockVo {
    private Long skuId;
    private Boolean hasStock;
}
