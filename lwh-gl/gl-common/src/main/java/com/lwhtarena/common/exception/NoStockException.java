package com.lwhtarena.common.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author liwh
 * @Title: NoStockException
 * @Package com.lwhtarena.common.exception
 * @Description: 无库存抛出的异常
 * @Version 1.0.0
 * @date 2020/9/3 22:08
 */
public class NoStockException extends RuntimeException {

    @Getter
    @Setter
    private Long skuId;

    public NoStockException(Long skuId) {
        super("商品id："+ skuId + "库存不足！");
    }

    public NoStockException(String msg) {
        super(msg);
    }


}
