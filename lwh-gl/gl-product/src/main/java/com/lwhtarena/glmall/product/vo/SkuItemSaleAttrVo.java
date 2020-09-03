package com.lwhtarena.glmall.product.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author liwh
 * @Title: SkuItemSaleAttrVo
 * @Package com.lwhtarena.glmall.product.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 21:50
 */
@Data
@ToString
public class SkuItemSaleAttrVo {

    private Long attrId;

    private String attrName;

    private List<AttrValueWithSkuIdVo> attrValues;
}
