package com.zapacademy.chatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.zapacademy"}) //Scan for annotated class
@EntityScan("com.zapacademy.entity")
@EnableJpaRepositories("com.zapacademy.repository")
public class ChatbotAppSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotAppSpringBootApplication.class, args);
	}

}
