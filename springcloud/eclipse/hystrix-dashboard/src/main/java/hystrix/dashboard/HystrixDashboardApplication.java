package hystrix.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
* http://localhost:1201/hystrix
* 
* http://localhost:8010/hystrix.stream
*
*/
@EnableHystrixDashboard
@SpringCloudApplication
public class HystrixDashboardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HystrixDashboardApplication.class, args);
	}

}
