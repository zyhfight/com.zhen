package com.spring.aop.proxy.dynamic;

import com.spring.aop.proxy.pattern.proxy.RealSubject;
import com.spring.aop.proxy.pattern.proxy.Subject;

import java.lang.reflect.Proxy;

/**
 * @author : zyh
 * @Description : com.spring.aop.proxy.dynamic
 * @date : 2019-01-01 13:23
 */
public class JdkProxyClient {
    public static void main(String[] args) {
        /**
         *  保存生成的代理类
         *  传入字符串"true"，而不是true！
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Subject subject = (Subject) Proxy.newProxyInstance(JdkProxyClient.class.getClassLoader(), new Class[]{Subject.class},
                new JdkProxySubject(new RealSubject()));

        subject.request();
        subject.hello();

    }
}
