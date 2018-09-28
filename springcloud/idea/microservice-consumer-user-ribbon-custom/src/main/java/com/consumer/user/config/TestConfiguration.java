package com.consumer.user.config;

import com.consumer.config.RibbonConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 使用@RibbonClient为指定名称的微服务自定义配置
 * configuration指定Ribbon的配置类
 * @author: zyh
 * @date: 2018-8-30
 */
@Configuration
@RibbonClient(name = "microservice-provider-user" , configuration = RibbonConfiguration.class)
public class TestConfiguration {
}
