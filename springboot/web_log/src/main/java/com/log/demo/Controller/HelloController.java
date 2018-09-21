package com.log.demo.Controller;

import org.springframework.web.bind.annotation.*;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

}
