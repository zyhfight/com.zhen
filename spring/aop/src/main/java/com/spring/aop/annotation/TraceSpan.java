package com.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * @author : zyh
 * @Description : com.spring.aop.annotation
 * 注解
 * @date : 2019-02-15 22:18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TraceSpan {

    String requestId();
}
