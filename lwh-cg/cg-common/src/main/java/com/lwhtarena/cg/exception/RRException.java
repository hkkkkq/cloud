package com.lwhtarena.cg.exception;

import com.lwhtarena.cg.constants.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author liwh
 * @Title: RRException
 * @Package com.lwhtarena.cg.exception
 * @Description: 自定义全局异常类
 * @Version 1.0.0
 * @date 2020/7/30 23:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class RRException extends RuntimeException {

    private Integer code;

    public RRException(String msg) {
        super(msg);
    }

    /**
     * 接收状态码和错误消息
     * @param code
     * @param message
     */
    public RRException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public RRException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "RRException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
