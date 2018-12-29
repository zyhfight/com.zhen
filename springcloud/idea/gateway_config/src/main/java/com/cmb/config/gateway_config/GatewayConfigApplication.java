package com.cmb.config.gateway_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
//@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class GatewayConfigApplication {

	public static void main(String[] args) {
		try {
			Field field = Class.forName("javax.crypto.JceSecurity").getDeclaredField("isRestricted");
			field.setAccessible(true);

			Field modifiersField = Field.class.getDeclaredField("modifiers");
			modifiersField.setAccessible(true);
			modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

			field.set(null, false);
		} catch (ClassNotFoundException | NoSuchFieldException | SecurityException | IllegalArgumentException
				| IllegalAccessException ex) {
			ex.printStackTrace(System.err);
		}

		SpringApplication.run(GatewayConfigApplication.class, args);
	}

}

