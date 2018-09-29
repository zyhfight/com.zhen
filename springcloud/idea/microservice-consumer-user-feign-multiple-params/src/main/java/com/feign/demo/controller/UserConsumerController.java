package com.feign.demo.controller;

import com.feign.demo.entity.User;
import com.feign.demo.feign.UserFeignClient;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
public class UserConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(UserConsumerController.class);

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return userFeignClient.findById(id);
    }

    /**
     * http://localhost:8010/user/get0?id=2&username=李四
     * GET请求多参数URL不支持此方式
     * 该请求不会成功
     * "Method Not Allowed" "Request method 'POST' not supported"
     * @param user
     * @return
     */
    @GetMapping("/user/get0")
    public User get0(User user) {
        return userFeignClient.get0(user);
    }

    /**
     * http://localhost:8010/user/get1?id=2&username=李四
     * 多参数GET请求URL，URL中有几个参数，Feign接口中就传递几个参数
     * @param user
     * @return
     */
    @GetMapping("/user/get1")
    public User get1(User user) {
        return userFeignClient.get1(user.getId(), user.getUsername());
    }

    /**
     * http://localhost:8010/user/get2?id=2&username=李四
     * 多参数的GET请求URL，通过Map构建
     * @param user
     * @return
     */
    @GetMapping("/user/get2")
    public User get2(User user) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("id", user.getId());
        map.put("username", user.getUsername());
        return userFeignClient.get2(map);
    }

    /**
     * http://localhost:8010/user/post?id=2&username=李四
     * @param user
     * @return
     */
    @GetMapping("/user/post")
    public User post(User user) {
        return userFeignClient.post(user);
    }

}
