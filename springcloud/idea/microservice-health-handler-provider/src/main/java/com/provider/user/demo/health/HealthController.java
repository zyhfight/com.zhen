package com.provider.user.demo.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 支持前端请求修改数据库连接状态
 * @author: zyh
 * @date: 2018-9-27
 */
@RestController
public class HealthController {
    static Boolean canVisitDb = false;

    @GetMapping("/db/{canVisitDb}")
    public String setConnectState(@PathVariable("canVisitDb") Boolean canVisitDb){
        HealthController.canVisitDb = canVisitDb;
        return "当前数据库连接是否正常：" + HealthController.canVisitDb;
    }
    
}
