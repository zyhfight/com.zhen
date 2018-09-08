package zuul.filter;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulFilterApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulFilterApplication.class).web(true).run(args);
	}
	
	@Bean
	public AccessZuulFilter accessZuulFilter(){
		return new AccessZuulFilter();
	}

}
