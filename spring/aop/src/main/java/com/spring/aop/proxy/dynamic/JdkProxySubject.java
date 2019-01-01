package com.spring.aop.proxy.dynamic;

import com.spring.aop.proxy.pattern.proxy.RealSubject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : zyh
 * @Description : 利用反射 动态生成代理类的method，RealSubject方法增删，JdkProxySubject无需同步更改
 * jdk动态代理，必须实现接口
 * @date : 2019-01-01 13:08
 */
public class JdkProxySubject implements InvocationHandler {

    private RealSubject realSubject;

    public JdkProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--- jdkProxy before ---");
        Object result = null;
        try {
            result = method.invoke(realSubject, args);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw  e;
        }finally {
            System.out.println("--- jdkProxy after ---");
        }
        return result;
    }
}
