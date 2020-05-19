package com.lwhtarena.mk.common.util.exception;

/**
 * @author liwh
 * @Title: CheckedException
 * @Package com.lwhtarena.mk.common.util.exception
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 18:06
 */
public class CheckedException extends RuntimeException{

    public CheckedException() {
    }

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(Throwable cause) {
        super(cause);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
