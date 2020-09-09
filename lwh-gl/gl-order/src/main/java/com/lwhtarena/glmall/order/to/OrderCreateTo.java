package com.lwhtarena.glmall.order.to;

import com.lwhtarena.glmall.order.entity.OrderEntity;
import com.lwhtarena.glmall.order.entity.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liwh
 * @Title: OrderCreateTo
 * @Package com.lwhtarena.glmall.order.to
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/9 16:23
 */

@Data
public class OrderCreateTo {

    private OrderEntity order;

    private List<OrderItemEntity> orderItems;

    /** 订单计算的应付价格 **/
    private BigDecimal payPrice;

    /** 运费 **/
    private BigDecimal fare;

}
