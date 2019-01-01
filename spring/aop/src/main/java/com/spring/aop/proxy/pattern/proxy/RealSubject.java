package com.spring.aop.proxy.pattern.proxy;

/**
 * @author : zyh
 * @Description : 动作实际执行类
 * @date : 2019-01-01 12:58
 */
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("--- RealSubject execute request method");
    }

    @Override
    public void hello() {
        System.out.println("hello");
    }
}
