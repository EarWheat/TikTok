package com.bjtv.tiktok;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
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
