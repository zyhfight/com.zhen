package com.spring.aop.proxy.pattern.chain;

import java.util.Arrays;
import java.util.List;

/**
 * @author : zyh
 * @Description : 责任链调用，封装了显式创建链
 * @date : 2019-01-01 14:37
 */
public class ChainClient {
    static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chainHandler a");
        }
    }

    static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chainHandler b");
        }
    }

    static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handleProcess() {
            System.out.println("chainHandler c");
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> handlers = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );
        Chain chain = new Chain(handlers);
        chain.process();
    }

}
