package com.consumer.user.feign;

import com.consumer.user.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 通过FallbackFactory 检查回退原因
 * @author: zyh
 * @date: 2018-9-8
 */
@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                FeignClientFallbackFactory.LOGGER.error("回退原因： {}",throwable);
                User user = new User();
                user.setId(-3L);
                user.setUsername("feign fallback 用户");
                return user;
            }
        };
    }
}
