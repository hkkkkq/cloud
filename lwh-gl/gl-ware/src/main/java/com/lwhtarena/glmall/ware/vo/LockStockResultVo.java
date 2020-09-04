package com.lwhtarena.glmall.ware.vo;

import lombok.Data;

/**
 * @author liwh
 * @Title: LockStockResultVo
 * @Package com.lwhtarena.glmall.ware.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/9/3 23:17
 */
@Data
public class LockStockResultVo {
    private Long skuId;

    private Integer num;

    /** 是否锁定成功 **/
    private Boolean locked;
}
