package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebMvcE2EApplication {

	/*public void addResourceHandlers(ResourceHandlerRegistry registry) {

	    registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/statics/")
	            .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
	}*/
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebMvcE2EApplication.class, args);
	}

}
