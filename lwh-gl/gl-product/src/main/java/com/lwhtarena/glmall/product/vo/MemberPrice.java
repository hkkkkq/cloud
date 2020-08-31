package com.lwhtarena.glmall.product.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liwh
 * @Title: MemberPrice
 * @Package com.lwhtarena.glmall.product.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/8/31 21:47
 */
@Data
public class MemberPrice {

    private Long id;
    private String name;
    private BigDecimal price;

}
