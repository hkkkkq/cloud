package com.lwhtarena.mk.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liwh
 * @Title: ErrorPojo
 * @Package com.lwhtarena.mk.common.vo
 * @Description: spring boot 的异常对象
 * @Version 1.0.0
 * @date 2020/5/19 17:57
 */
@Data
public class ErrorPojo implements Serializable {

    @JSONField(name = "timestamp")
    private long timestamp;
    @JSONField(name = "status")
    private int status;
    @JSONField(name = "error")
    private String error;
    @JSONField(name = "exception")
    private String exception;
    @JSONField(name = "message")
    private String message;
    @JSONField(name = "path")
    private String path;

}
