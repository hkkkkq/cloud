package com.lwhtarena.nl.model.annotation;

import java.lang.annotation.*;

/**
 * @author liwh
 * @Title: DateConvert
 * @Package com.lwhtarena.nl.model.annotation
 * @Description: 日期类型转换注解
 * @Version 1.0.0
 * @date 2020/5/15 09:05
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface DateConvert {
    String value() default "";
}
