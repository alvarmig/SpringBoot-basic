/**
 * @Description: 
 * @Author: Daniel Beltran
 * @Date: Sep 7, 2019
 */
package com.zapacademy.chatbot;

/**
 * @Description: 
 * @Author: Daniel Beltran
 * @Date: Sep 7, 2019
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ComponentScan({"com.zapacademy"})
@EntityScan("com.zapacademy.entity")
@EnableJpaRepositories("com.zapacademy.repository")

public class ChatbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatbotApplication.class, args);
	}
	
	//http://localhost:8080/projecto/chatbot.html
}
