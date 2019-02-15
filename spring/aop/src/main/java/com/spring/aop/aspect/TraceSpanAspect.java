package com.spring.aop.aspect;

import com.spring.aop.annotation.TraceSpan;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author : zyh
 * @Description : com.spring.aop.aspect
 * 编写切面
 * @date : 2019-02-15 22:20
 */
@Aspect
@Component
public class TraceSpanAspect {


    @Around(value = "( execution( * com.spring.aop..*(..) ) ) && @annotation(traceSpan)", argNames = "joinPoint, traceSpan")
    public void around(JoinPoint joinPoint, TraceSpan traceSpan) {


        System.err.println("requestId:" + traceSpan.requestId());


        System.err.println("创建span");
        System.err.println("添加spanTag");

        try {

            ( (ProceedingJoinPoint) joinPoint ).proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {
            System.err.println("关闭 span");
        }

    }


//    @Pointcut("@annotation(com.spring.aop.annotation.TraceSpan)")
//    public void annotationPointCut() {
//
//    }
//    @Around("annotationPointCut()")
//    public void around(JoinPoint joinPoint) {
//
//        System.err.println("创建span");
//        System.err.println("添加spanTag");
//
//        try {
//
//            ( (ProceedingJoinPoint) joinPoint ).proceed();
//
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }finally {
//            System.err.println("关闭 span");
//        }
//
//    }

}
