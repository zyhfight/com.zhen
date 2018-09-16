package com.springboot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zyh
 * @Description: hello
 * @date Date : 2018年09月15日 下午4:08
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello springboot.";
    }

}
