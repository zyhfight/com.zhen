package com.example.demo.service;

import com.example.demo.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;


/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-9-8
 */
@Service
public class AggregationService {
    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getUserById(Long id){
        //创建一个观察者
        return Observable.create(observer -> {
            //请求provider user微服务的{id}端点
            User user = restTemplate.getForObject("http://microservice-provider-user/{id}", User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getConsumerUserById(Long id){
        return Observable.create(observer -> {
            //请求consumer user微服务/user/{id}端点
            User user = restTemplate.getForObject("http://microservice-consumer-user/user/{id}",User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });
    }

    //fallback回退方法形参要与正常方法一致
    public  User fallback(Long id){
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");
        return user;
    }
}
