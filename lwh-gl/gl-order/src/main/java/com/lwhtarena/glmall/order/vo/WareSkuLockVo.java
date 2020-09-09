package com.lwhtarena.glmall.order.vo;

import lombok.Data;

import java.util.List;

/**
 * @author liwh
 * @Title: WareSkuLockVo
 * @Package com.lwhtarena.glmall.order.vo
 * @Description: 锁定库存的vo
 * @Version 1.0.0
 * @date 2020/9/9 16:21
 */

@Data
public class WareSkuLockVo {

    private String orderSn;

    /** 需要锁住的所有库存信息 **/
    private List<OrderItemVo> locks;
}
