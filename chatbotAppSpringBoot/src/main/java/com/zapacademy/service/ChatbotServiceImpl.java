package com.zapacademy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapacademy.entity.ChatbotUserEntity;
import com.zapacademy.repository.ChatbotUserRepository;

@Service
public class ChatbotServiceImpl implements ChatbotService {
	
	@Autowired
	private ChatbotUserRepository chatbotUserRepository;
	
	@Override
	public boolean searchName(String userName) {
		
		Optional<ChatbotUserEntity> optionalUser = chatbotUserRepository.findById(userName);

		return optionalUser.isPresent();
	}

	@Override
	public void saveName(String userName) {
		ChatbotUserEntity chatbotUserEntity = new ChatbotUserEntity();
		
		chatbotUserEntity.setName(userName);
		
		chatbotUserRepository.save(chatbotUserEntity);
	}

	@Override
	public boolean updateName(String oldName, String newName) {
		Optional<ChatbotUserEntity> optionalUser = chatbotUserRepository.findById(oldName);
		
		if(optionalUser.isPresent()) {
			ChatbotUserEntity chatbotUserEntity = optionalUser.get();
			
			chatbotUserRepository.delete(chatbotUserEntity);
			
			chatbotUserEntity.setName(newName);
			
			chatbotUserRepository.save(chatbotUserEntity);
			
			return true;
		}
		return false;
	}

}
