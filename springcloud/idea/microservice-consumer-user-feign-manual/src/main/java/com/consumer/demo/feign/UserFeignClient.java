package com.consumer.demo.feign;


import com.consumer.demo.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-8-31
 */
public interface UserFeignClient {

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
