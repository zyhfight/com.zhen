package com.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Ribbon配置类
 * 该类不应该在主应用程序上下文的@ComponentScan所扫描的包中，
 * 否则该类中的配置信息将会被所有的@RibbonClient共享
 * @author: zyh
 * @date: 2018-8-30
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
