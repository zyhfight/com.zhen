package com.consumer.user.config;

import com.consumer.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 该类的功能描述
 * @author: zyh
 * @date: 2018-8-30
 */
@Configuration
@RibbonClient(name = "microservice-provider-user" , configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
