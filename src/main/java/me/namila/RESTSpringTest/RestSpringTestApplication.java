package me.namila.RESTSpringTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
public class RestSpringTestApplication
{

	public static void main( String[] args )
	{
		SpringApplication.run( RestSpringTestApplication.class, args );
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor()
	{
		return new MethodValidationPostProcessor();
	}

}
