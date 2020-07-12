package com.lwhtarena.cg.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import java.lang.annotation.*;

/**
 * @author liwh
 * @Title: CanalEventListener
 * @Package com.lwhtarena.cg.annotation
 * @Description: 功能描述:canal 监听器注解，继承 @Component
 * @Version 1.0.0
 * @date 2020/7/12 15:17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface CanalEventListener {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
