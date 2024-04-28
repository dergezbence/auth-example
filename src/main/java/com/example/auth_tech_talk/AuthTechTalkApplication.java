package com.example.auth_tech_talk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class AuthTechTalkApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthTechTalkApplication.class, args);
	}

}
