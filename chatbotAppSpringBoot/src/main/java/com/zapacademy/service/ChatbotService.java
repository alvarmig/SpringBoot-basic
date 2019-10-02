package com.zapacademy.service;

public interface ChatbotService {
	boolean searchName(String userName);
	
	void saveName(String userName);
	
	boolean updateName(String oldName, String newName);
}
