package eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/test")
	public String dc() throws InterruptedException{
		//Thread.sleep(5000L);//触发hystrix服务降级
		String services = "Services: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
	
}
