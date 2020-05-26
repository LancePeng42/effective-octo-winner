package com.citic.payment.configurer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CrosConfig extends WebMvcConfigurerAdapter
{
	@Override
    public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")  
		.allowedHeaders("*")
        .allowedOrigins("*")  
        .allowCredentials(true)  
        .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS")  
        .maxAge(3600); 
	}

}
