package com.lwhtarena.cg.vo;

import com.lwhtarena.cg.constants.ResultCodeEnum;

import java.util.HashMap;

/**
 * @author liwh
 * @Title: R
 * @Package com.lwhtarena.cg.vo
 * @Description:
 * @Version 1.0.0
 * @date 2020/7/31 00:02
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    private R() {
        put("code", ResultCodeEnum.SUCCESS.getCode());
        put("success", ResultCodeEnum.SUCCESS.getSuccess());
        put("msg", ResultCodeEnum.SUCCESS.getMessage());
    }

    public static R ok() {
        return new R();
    }

    public static R ok(Object data) {
        R r = new R();
        r.put("data", data);
        return r;
    }

    public static R error() {
        return error(ResultCodeEnum.UNKNOWN_REASON.getCode(), ResultCodeEnum.UNKNOWN_REASON.getMessage());
    }

    public static R error(String msg) {
        return error(ResultCodeEnum.UNKNOWN_REASON.getCode(), msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        r.put("success", false);
        return r;
    }

    public static R error(ResultCodeEnum resultCodeEnum) {
        R r = new R();
        r.put("code", resultCodeEnum.getCode());
        r.put("success", resultCodeEnum.getSuccess());
        r.put("msg", resultCodeEnum.getMessage());
        return r;
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
