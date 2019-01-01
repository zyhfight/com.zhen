package com.spring.aop.proxy.pattern.chain;

/**
 * @author : zyh
 * @Description : 责任链调用；需要手动创建链式调用，随着链变化，代码需要同步修改
 * @date : 2019-01-01 14:23
 */
public class HandlerClient {

    static class HandlerA extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println(" handle by chain a ");
        }
    }

    static class HandlerB extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println(" handle by chain b ");
        }
    }

    static class HandlerC extends Handler {
        @Override
        protected void handleProcess() {
            System.out.println(" handle by chain c ");
        }
    }

    public static void main(String[] args) {
        //创建责任链
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSucessor(handlerB);
        handlerB.setSucessor(handlerC);
        //只关注链头
        handlerA.execute();
    }

}
