package com.spring.aop.controller;

import com.spring.aop.annotation.TraceSpan;
import com.spring.aop.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zyh
 * @Description : com.spring.aop.controller
 * @date : 2019-02-15 22:26
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    @TraceSpan(requestId = "hi")
    public String hello() {

        helloService.print();


        return "success";
    }
}
