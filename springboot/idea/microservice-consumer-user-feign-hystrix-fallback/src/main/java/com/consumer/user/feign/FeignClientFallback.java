//package com.consumer.user.feign;
//
//import com.consumer.user.entity.User;
//import org.springframework.stereotype.Component;
//
///**
// * @Description: 该类的功能描述
// * @author: zyh
// * @date: 2018-9-8
// */
//@Component
//public class FeignClientFallback implements UserFeignClient {
//    @Override
//    public User findById(Long id) {
//
//        User user = new User();
//        user.setId(-2L);
//        user.setUsername("fallback用户");
//        return user;
//    }
//}
