package com.gl.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan({"controller","model","service","dao","com.gl.training","exceptionHandler"})
public class Medicare2Application {

	public static void main(String[] args) {
		SpringApplication.run(Medicare2Application.class, args);
	}
}
