package com.feign.demo.feign;

import com.feign.config.FeignConfiguration;
import com.feign.demo.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 使用@FeignClient的configuration属性，指定feign配置类
 * @author: zyh
 * @date: 2018-8-31
 */
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 使用feign 自带的注解@RequestLine；由于使用了feign原生默认契约，使用@RequestMapping注解会报错
     * @要使用feign的@Param注解
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    User findById(@Param("id") Long id);
}
