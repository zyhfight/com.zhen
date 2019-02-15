package com.spring.aop.service.impl;

import com.spring.aop.annotation.TraceSpan;
import com.spring.aop.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author : zyh
 * @Description : com.spring.aop.service.impl
 * @date : 2019-02-15 22:30
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    @TraceSpan(requestId = "123")
    public void print() {
        try {
            Thread.sleep(1000L);
            double i = 1/0;
            System.out.println("哈哈");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
