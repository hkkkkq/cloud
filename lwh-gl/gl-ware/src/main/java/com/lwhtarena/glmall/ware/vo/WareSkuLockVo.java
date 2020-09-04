package com.lwhtarena.glmall.ware.vo;

import lombok.Data;

import java.util.List;

/**
 * @author liwh
 * @Title: WareSkuLockVo
 * @Package com.lwhtarena.glmall.ware.vo
 * @Description: 锁定库存的vo
 * @Version 1.0.0
 * @date 2020/9/3 23:16
 */
@Data
public class WareSkuLockVo {
    private String orderSn;

    /** 需要锁住的所有库存信息 **/
    private List<OrderItemVo> locks;
}
