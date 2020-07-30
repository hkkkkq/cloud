package com.lwhtarena.cg.exception;

import com.lwhtarena.cg.vo.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author liwh
 * @Title: RRExceptionHandler
 * @Package com.lwhtarena.cg.exception
 * @Description: 异常处理器
 * @Version 1.0.0
 * @date 2020/7/30 23:56
 */
@RestControllerAdvice
@Slf4j
public class RRExceptionHandler {
    /**
     * 处理自定义异常
     */
    @ExceptionHandler(RRException.class)
    public R handleRRException(RRException e){
        e.printStackTrace();
        return R.error(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        log.error(e.getMessage());
        return R.error();
    }

}
