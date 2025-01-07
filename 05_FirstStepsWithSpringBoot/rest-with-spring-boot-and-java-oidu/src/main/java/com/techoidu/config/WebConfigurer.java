package com.techoidu.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.techoidu.serialization.converter.YamalJckson2HttpMessageConverter;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	
	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("aplication/x-yaml");
	
	@Value("${cors.originPatterns: default}")
	private String corsOriginPatterns = "";
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamalJckson2HttpMessageConverter());
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		var allowedOrigin = corsOriginPatterns.split(",");
		registry.addMapping("/**")
		//.allowedMethods("GET", "POST", "PUT") => QUANDO QUEREMOS QUE METODOS ESPECIFICOS TENHAM ACESSO 
		.allowedMethods("*")
		.allowedOrigins(allowedOrigin)
		.allowCredentials(true);
		
	}
	
    //@Override
   /* public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
            .parameterName("mediaType")
            .ignoreAcceptHeader(false)
            .useRegisteredExtensionsOnly(false)
            .defaultContentType(MediaType.APPLICATION_JSON)
            .mediaType("json", MediaType.APPLICATION_JSON)
            .mediaType("xml", MediaType.APPLICATION_XML);
    */    
        
 // Via HEADER PARAM. http://localhost:8080/api/person/v1
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
            configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
    }


	

}

