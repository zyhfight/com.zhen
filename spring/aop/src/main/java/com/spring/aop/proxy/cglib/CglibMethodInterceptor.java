package com.spring.aop.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : zyh
 * @Description : cglib，支持继承动态代理
 * @date : 2019-01-01 13:44
 */
public class CglibMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        System.out.println("--- cglib before ---");
        Object resut = null;
        try{
            resut = proxy.invokeSuper(obj, args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            System.out.println("--- cglib after---");
        }
        return resut;
    }
}
