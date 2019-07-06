package com.app;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@SpringBootApplication
public class SpringBootWebMvcE2EApplication {

	public void addResourceHandlers(ResourceHandlerRegistry registry) {

	    registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcE2EApplication.class, args);
	}

}
