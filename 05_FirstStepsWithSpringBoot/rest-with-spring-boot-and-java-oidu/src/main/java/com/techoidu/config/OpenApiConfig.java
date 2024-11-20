package com.techoidu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	OpenAPI customOpenAPI() {
		
		return new OpenAPI()
				.info(new Info()
				.title("RestFull API Java 21")
				.version("V1")
				.description("First api restfull")
				.termsOfService("http://dslist-production-fb24.up.railway.app/lists/2/games")
				.license(
					new License() 
						.name("Apache 2.0")
						.url("http://dslist-production-fb24.up.railway.app/lists/2/games")
						)
				);
			
		
		
	}

}
