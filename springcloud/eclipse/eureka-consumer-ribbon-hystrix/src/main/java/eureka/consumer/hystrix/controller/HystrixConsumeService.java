package eureka.consumer.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class HystrixConsumeService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "fallback")
	public String hystrixConsumer(){
		return restTemplate.getForObject("http://eureka-client/test", String.class);
	}
	
	public String fallback(){
		return "fallback";
	}
	
}
