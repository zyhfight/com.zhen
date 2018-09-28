package com.provider.user.demo.health;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @Description: 服务提供者把健康状态告知Eureka server；
 * healthCheckHandler会将应用的健康状态保存到内存，状态一旦发生变化，就会重新向Eureka Server进行注册
 * @author: zyh
 * @date: 2018-9-27
 */
@Component
public class MyHealthCheckHandler implements HealthCheckHandler {
    @Autowired
    private MyHealthIndicator indicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus currentStatus) {
        Status status = indicator.health().getStatus();
        if(Status.UP.equals(status)){
            return InstanceInfo.InstanceStatus.UP;
        }else {
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
