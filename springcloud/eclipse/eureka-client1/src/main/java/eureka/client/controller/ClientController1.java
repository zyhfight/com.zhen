package eureka.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientController1 {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("/test")
	public String dc(){
		String services = "Services1: " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
	
}
