package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
* /refresh端点
* 发送POST请求到其中一个Config Client实例的/bus/refresh端点
* eg：http://localhost:8081/bus/refresh
* 借助Git仓库的WebHooks即可实现配置的自动刷新。
*/
@SpringBootApplication
@EnableConfigServer
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
