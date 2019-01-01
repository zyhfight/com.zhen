package com.spring.aop.proxy.pattern.proxy;

/**
 * @author : zyh
 * @Description : 动态代理模式
 * 静态代理，执行RealSubject method；如果RealSubject中方法增删，Proxy类需要同步修改
 * @date : 2019-01-01 13:00
 */
public class ProxySubject implements Subject{

    private RealSubject realSubject;

    public ProxySubject (RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        System.out.println("--- Proxy before ---");
        try{
            realSubject.request();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }finally {
            System.out.println("--- Proxy after ---");
        }

    }

    @Override
    public void hello() {
        System.out.println("--- Proxy hello ---");
        realSubject.hello();
    }
}
