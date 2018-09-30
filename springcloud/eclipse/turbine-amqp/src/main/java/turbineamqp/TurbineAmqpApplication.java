package turbineamqp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;

/**
* http://localhost:8989/hystrix.stream
*
* http://localhost:8990/turbine.stream
*
*
*/
@Configuration
@EnableAutoConfiguration
@EnableTurbineStream
@EnableDiscoveryClient
public class TurbineAmqpApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(TurbineAmqpApplication.class, args);
	}

}
