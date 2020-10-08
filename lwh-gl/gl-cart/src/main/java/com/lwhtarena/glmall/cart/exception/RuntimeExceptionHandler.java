package com.lwhtarena.glmall.cart.exception;

import com.lwhtarena.common.utils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author liwh
 * @Title: RuntimeExceptionHandler
 * @Package com.lwhtarena.glmall.cart.exception
 * @Description: 统一异常处理
 * @Version 1.0.0
 * @date 2020/10/9 03:46
 */
@ControllerAdvice
public class RuntimeExceptionHandler {

    /**
     * 全局统一异常处理
     * @param exception
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public R handler(RuntimeException exception) {
        return R.error(exception.getMessage());
    }


    @ExceptionHandler(CartExceptionHandler.class)
    public R userHandler(CartExceptionHandler exception) {
        return R.error("购物车无此商品");
    }
}
