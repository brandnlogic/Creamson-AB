package com.bnl.creamson.ptm.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configurable
public class SwaggerConfig {
	
	/**
	 * Only configuring the controller with meetingschedule
	 * @return
	 */
	@Bean
	public Docket api() {                
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()                                       
	      .apis(RequestHandlerSelectors.basePackage("com.bnl.creamson.ptm.controller"))
	      .paths(PathSelectors.any())
	      .build()
	      .apiInfo(apiInfo())
	      .tags(new Tag("Description", "Through this API you can schedule a meeting with Parents and Teachers"));	
	    	
	}
	
	private ApiInfo apiInfo() {
	     return new ApiInfoBuilder()
	    		 .title("Creamson Meeting Schedule")
	    		 .contact(new springfox.documentation.service.Contact("Abhideep", "creamson.com", "abhideep@brandnlogic.com"))
	    		 .version("1.0.0")
	    		 .build();
	}
}
