package eureka.consumer.hystrix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixController {
	
	@Autowired
	HystrixConsumeService hystrixConsumeService;
	
	@GetMapping("/hystrixCosunme")
	public String consume(){
		return hystrixConsumeService.hystrixConsumer();
	}

}
