package com.lwhtarena.mk.common.util.exception;

/**
 * @author liwh
 * @Title: PigDeniedException
 * @Package com.lwhtarena.mk.common.util.exception
 * @Description: 403 授权拒绝
 * @Version 1.0.0
 * @date 2020/5/19 18:19
 */
public class MTDeniedException extends RuntimeException{

    public MTDeniedException() {
    }

    public MTDeniedException(String message) {
        super(message);
    }

    public MTDeniedException(Throwable cause) {
        super(cause);
    }

    public MTDeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public MTDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
