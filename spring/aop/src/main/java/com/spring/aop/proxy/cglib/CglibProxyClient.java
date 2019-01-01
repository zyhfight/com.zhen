package com.spring.aop.proxy.cglib;

import com.spring.aop.proxy.pattern.proxy.RealSubject;
import com.spring.aop.proxy.pattern.proxy.Subject;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author : zyh
 * @Description : cglib 动态代理
 * @date : 2019-01-01 13:51
 */
public class CglibProxyClient {

    public static void main(String[] args) {

        /**
         * 生成cglib生成的代理类
         */
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "com/cglib/proxy");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CglibMethodInterceptor());
        Subject subject = (Subject) enhancer.create();
        subject.request();
        subject.hello();
    }

}
