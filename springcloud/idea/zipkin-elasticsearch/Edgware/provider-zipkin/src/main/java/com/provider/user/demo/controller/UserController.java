package com.provider.user.demo.controller;

import com.provider.user.demo.dao.UserRepository;
import com.provider.user.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-8-29
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-8-29     zyh           v1.0.0               修改原因
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id){
        User user = userRepository.findOne(id);
        return user;
    }

    @GetMapping("/user")
    public String findById(){
        return "1";
    }

}
