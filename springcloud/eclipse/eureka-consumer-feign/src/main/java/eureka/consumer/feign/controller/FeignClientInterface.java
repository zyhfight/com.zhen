package eureka.consumer.feign.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface FeignClientInterface {
	
	@GetMapping("/test")
	String consume();

}
