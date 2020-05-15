package com.lwhtarena.nl.model.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liwh
 * @Title: IdEncrypt
 * @Package com.lwhtarena.nl.model.annotation
 * @Description:
 * @Version 1.0.0
 * @date 2020/5/15 09:06
 */
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface IdEncrypt {
}
