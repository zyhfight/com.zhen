package com.spring.aop.proxy.pattern.chain;

/**
 * @author : zyh
 * @Description : 责任链模式，封装链式调用
 * @date : 2019-01-01 14:29
 */
public abstract class ChainHandler {
    public void execute(Chain chain){
        handleProcess();
        //递归调用
        chain.process();
    }

    /**
     * 责任链实际处理逻辑
     */
    protected abstract void handleProcess();
}
