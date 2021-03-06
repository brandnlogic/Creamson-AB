package com.bnl.creamson.ptm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PTMApplicationConfig extends SpringBootServletInitializer
{
		private static Class<PTMApplicationConfig> applicationClass = PTMApplicationConfig.class;
	    
	    
	    public static void main(String[] args) {
	    	// SpringApplication take the command argument and name of the class that extends the spring boot
	    	new SpringApplicationBuilder(PTMApplicationConfig.class)
            .properties("spring.profiles.active=dev")
            .build().run(args);
	    }

	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(applicationClass);
	    }
	    
}