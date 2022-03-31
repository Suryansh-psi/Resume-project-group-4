package com.resume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Resume project Group 4", version = "1.0.0", description = "API for resume project"))
public class ResumeProjectGroup4Application {

	public static void main(String[] args) {
		SpringApplication.run(ResumeProjectGroup4Application.class, args);
	}

}
