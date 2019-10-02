package com.zapacademy.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zapacademy.dto.responses.MessageResponse;
import com.zapacademy.service.ChatbotService;

@RestController
@RequestMapping(value="/")
public class ChatbotController {
	
	@Autowired
	private ChatbotService chatbotService;
	
	@GetMapping(value="/app_type", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> applicationType() {
		return ResponseEntity.ok("{ \"valor\": \"JAVA :P\" }");
		
	}
	
	@GetMapping(value="/chatbot_controller", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MessageResponse> processMessage(@RequestParam(value = "mensaje") String message) {
		
		MessageResponse messageResponse = new MessageResponse();
		
		messageResponse.setText("No entendi lo que dijiste!");
		messageResponse.setEmoticon("pensativo");
		
		
		if(message.toLowerCase().startsWith("hola")) {
			messageResponse.setText("Que tal, como te llamas?");
			messageResponse.setEmoticon("");
		}else if(message.toLowerCase().startsWith("me llamo")) {
			
			Pattern pattern = Pattern.compile("me llamo (\\w+)");
			Matcher matcher = pattern.matcher(message);
			
			if(matcher.matches()) {
				String userName = matcher.group(1);
				
				searchName(userName, messageResponse);
			}
		}else if(message.toLowerCase().contains("me cambie de nombre")){
			
			messageResponse.setText("orale!!!, ahora como te llamas?");
			messageResponse.setEmoticon("sorprendido");
		}
		else {
			
			Pattern pattern = Pattern.compile("me llamaba (\\w+) y ahora me llamo (\\w+)");
			Matcher matcher = pattern.matcher(message);
			
			if (matcher.matches()) {
				String oldName = matcher.group(1);
				String newName    = matcher.group(2);
				
				updateName(oldName, newName, messageResponse);
			}
		}
		
		return ResponseEntity.ok(messageResponse);
		
	}
	
	private MessageResponse searchName(String userName, MessageResponse messageResponse) {
		
		if(chatbotService.searchName(userName)) {
			messageResponse.setText("Regresaste!!, como has estado?");
			messageResponse.setEmoticon("encantado");
		}else {
			chatbotService.saveName(userName);
			messageResponse.setText("mucho gusto " + userName + ", como estas?");
			messageResponse.setEmoticon("abrazo");
		}
		
		return messageResponse;
	}
	
	public MessageResponse updateName(String oldName, String newName, MessageResponse messageResponse) {
		
		if(chatbotService.updateName(oldName, newName)) {
			messageResponse.setText("Listo " + newName + ", ya lo actualice!");
			messageResponse.setEmoticon("listo");
		}else {
			messageResponse.setText("haaa, ese nombre ni lo tenia!");
			messageResponse.setEmoticon("nelpastel");
		}
		
		return messageResponse;
	}
}
