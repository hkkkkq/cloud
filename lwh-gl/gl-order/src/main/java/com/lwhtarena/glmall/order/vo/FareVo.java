package com.lwhtarena.glmall.order.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liwh
 * @Title: FareVo
 * @Package com.lwhtarena.glmall.order.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:16
 */
@Data
public class FareVo {

    private MemberAddressVo address;

    private BigDecimal fare;
}

