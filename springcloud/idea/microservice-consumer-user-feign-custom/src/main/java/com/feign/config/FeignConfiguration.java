package com.feign.config;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Feign配置类
 * 该类可以不写@Configuration注解，如果加了@Configuration注解，那么该类不能放在主应用程序上下文@ComponScan所扫描包中；
 * 否则，该类中配置的feign.Decoder、feign Encoder、feign.Contract等配置会被所有的@FeignClient共享
 * 建议不在指定名称的Feign配置类上加@Configuration注解
 * @author: zyh
 * @date: 2018-9-29
 */
@Configuration
public class FeignConfiguration {

    /**
     * 将契约改为feign原生的默认契约；这样就可以使用feign自带注解了
     * @return 默认feign契约
     */
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

    //类似的还可以自定义Feign的编码器、解码器、日志打印、甚至为Feign添加拦截器。

    /**
     * 一些借口需要进行基于Http Basic认证才能调用，则可增加下列代码
     * @return
     */
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user","password");
//    }
}
