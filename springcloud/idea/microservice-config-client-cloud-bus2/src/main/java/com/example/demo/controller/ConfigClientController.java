package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-9-8
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${name}")
    private String name;

    @GetMapping("/profile")
    public String hello() {
        return this.name;
    }
}
