package com.spring.aop.proxy.pattern.chain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author : zyh
 * @Description : 责任链模式，需要手动进行链式调用
 * @date : 2019-01-01 14:16
 */
@Getter
@Setter
public abstract class Handler {

    private Handler sucessor;

    public void execute() {
        //调用实际处理逻辑
        handleProcess();
        //如果责任链未结束，则继续调用execute
        if (sucessor != null) {
            sucessor.execute();
        }
    }

    /**
     * 责任链实际处理逻辑
     */
    protected abstract void handleProcess();

}
