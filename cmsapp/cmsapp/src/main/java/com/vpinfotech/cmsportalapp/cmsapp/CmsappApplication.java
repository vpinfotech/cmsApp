package com.vpinfotech.cmsportalapp.cmsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@EnableAsync(proxyTargetClass=true)
@SpringBootApplication
@ComponentScan(basePackages="com.vpinfotech.cmsportalapp.cmsapp")
@Configuration
@EnableAutoConfiguration
public class CmsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsappApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
