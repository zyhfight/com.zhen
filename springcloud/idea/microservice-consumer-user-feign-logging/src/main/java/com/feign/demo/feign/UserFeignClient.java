package com.feign.demo.feign;

//import com.feign.config.FeignLogConfiguaration;
import com.feign.demo.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-8-31
 */
//@FeignClient(name = "microservice-provider-user", configuration = FeignLogConfiguaration.class)
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    User findById(@PathVariable("id") Long id);
}
