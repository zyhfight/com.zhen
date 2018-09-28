package com.provider.user.demo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @Description: 自检 健康指示器
 * @author: zyh
 * @date: 2018-9-27
 */
@Component
public class MyHealthIndicator implements HealthIndicator{

    @Override
    public Health health() {
        if(HealthController.canVisitDb){
            return Health.status(Status.UP).build();
        }else {
            return Health.status(Status.DOWN).build();
        }

    }
}
