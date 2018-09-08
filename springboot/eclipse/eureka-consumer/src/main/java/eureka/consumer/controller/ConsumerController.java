package eureka.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@RequestMapping("/eureka-consumer") //添加这个url消费时，获取ServiceInstance为null，导致NullPointerException
public class ConsumerController {
	
	@Autowired
	LoadBalancerClient loadBalancerClient;
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/consume")
	public String consumer(){
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
		String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/test";
		System.out.println("消费URL： " + url);
		return restTemplate.getForObject(url, String.class);
	}

}
