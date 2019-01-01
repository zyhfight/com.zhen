package com.spring.aop.proxy.pattern.chain;

import java.util.List;

/**
 * @author : zyh
 * @Description : 责任链，封装链式调用
 * @date : 2019-01-01 14:30
 */
public class Chain {

    private List<ChainHandler> handlers;

    /**
     *    责任链游标
     */
    private int index = 0;

    public Chain(List<ChainHandler> handlers) {
        this.handlers = handlers;
    }

    public void process() {
        //游标到达链尾，递归结束
        if (index >= handlers.size()){
            return;
        }
        //实现递归调用
        handlers.get(index++).execute(this);
    }

}
