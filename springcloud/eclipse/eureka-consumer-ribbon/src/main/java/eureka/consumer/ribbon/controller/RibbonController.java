package eureka.consumer.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/ribbonCosunme")
	public String ribbonConsumer(){
		return restTemplate.getForObject("http://eureka-client/test", String.class);
	}
	
}
