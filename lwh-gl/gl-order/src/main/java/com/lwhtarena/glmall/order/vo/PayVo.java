package com.lwhtarena.glmall.order.vo;

import lombok.Data;

/**
 * @author liwh
 * @Title: PayVo
 * @Package com.lwhtarena.glmall.order.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:20
 */

@Data
public class PayVo {
    private String out_trade_no; // 商户订单号 必填
    private String subject; // 订单名称 必填
    private String total_amount;  // 付款金额 必填
    private String body; // 商品描述 可空
}
