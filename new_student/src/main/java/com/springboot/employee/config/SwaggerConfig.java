package com.springboot.employee.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
////	private List<String> ;
//	@Bean
//    public Docket productApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select().apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
//                .paths(regex("/api/tan*"))
//                .build();
//
//    }
//	public class SwaggerUiWebMvcConfigurer implements WebMvcConfigurer {
//		  private final String baseUrl;
//		 
//	public SwaggerUiWebMvcConfigurer(String baseUrl) {
//		    this.baseUrl = "http://localhost:8080/api/tan/employee";
//		  }
//	@Override
//	  public void addViewControllers(ViewControllerRegistry registry) {
//	    registry.addViewController(baseUrl + "/swagger-ui/")
//	        .setViewName("forward:" + baseUrl + "/swagger-ui/index.html");
//	  }
//	}	  
////	private ApiInfo apiInfo() {
////        return new ApiInfo(
////                "My REST API", //title
////                "Some custom description of API.", //description
////                "Version 1.0", //version
////                "Terms of service", //terms of service URL
////                new Contact("Bhanuka Dissanayake", "www.example.com", "myeaddress@company.com"),
////                "License of API", "API license URL", new ArrayList<VendorExtension>()); // contact info
////    }
//
//}
