package com.lwhtarena.glmall.ware.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author liwh
 * @Title: FareVo
 * @Package com.lwhtarena.glmall.ware.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 23:17
 */

@Data
public class FareVo {
    private MemberAddressVo address;
    private BigDecimal fare;
}
