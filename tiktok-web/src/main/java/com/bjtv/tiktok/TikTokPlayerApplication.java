package com.bjtv.tiktok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.pangu")
@ComponentScan(value = "com.tiktok")
public class TikTokPlayerApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(TikTokPlayerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(TikTokPlayerApplication.class);
		springApplication.run(args);
	}

}
