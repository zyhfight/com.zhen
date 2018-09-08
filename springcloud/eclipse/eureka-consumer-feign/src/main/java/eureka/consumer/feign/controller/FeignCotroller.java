package eureka.consumer.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignCotroller {

	@Autowired
	FeignClientInterface feignClientInterface;
	
	@GetMapping("/feignCousume")
	public String feignConsume(){
		return feignClientInterface.consume();
	}
	
}
