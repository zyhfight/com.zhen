package com.spring.aop.proxy.pattern.proxy;

/**
 * @author : zyh
 * @Description : spring aop使用动态代理模式，实现面向切面编程，动态织入方法。
 * @date : 2019-01-01 13:05
 */
public class ProxyClient {

    public static void main(String[] args) {
        Subject subject = new ProxySubject(new RealSubject());
        subject.request();
        subject.hello();
    }
}
