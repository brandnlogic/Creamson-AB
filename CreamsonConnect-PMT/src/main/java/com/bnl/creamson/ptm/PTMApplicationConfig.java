package com.bnl.creamson.ptm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PTMApplicationConfig extends SpringBootServletInitializer
{
	    public static void main(String[] args) {
	    	
	    	new SpringApplicationBuilder(PTMApplicationConfig.class)
	                 .properties("spring.profiles.active:dev")
	                 .build().run(args);
	  
	    }
	    
}