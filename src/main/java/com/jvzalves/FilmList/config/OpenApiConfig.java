package com.jvzalves.filmlist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI customOpenApi() {
		 return new OpenAPI()
	     .info(new Info()
	    	.title("BoxOffice-SpringBoot")
	    	.version("v1")
	    	.description("API that simulates a film registration system")
	    	.termsOfService("")
	    	.license(new License().name("Apache 2.0")
	    	.url("")));
		}
	}
