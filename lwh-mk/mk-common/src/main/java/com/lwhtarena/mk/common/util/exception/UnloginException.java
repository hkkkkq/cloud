package com.lwhtarena.mk.common.util.exception;

/**
 * @author liwh
 * @Title: UnloginException
 * @Package com.lwhtarena.mk.common.util.exception
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/19 18:40
 */
public class UnloginException extends RuntimeException{
    public UnloginException() {
    }

    public UnloginException(String message) {
        super(message);
    }

    public UnloginException(Throwable cause) {
        super(cause);
    }

    public UnloginException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnloginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
