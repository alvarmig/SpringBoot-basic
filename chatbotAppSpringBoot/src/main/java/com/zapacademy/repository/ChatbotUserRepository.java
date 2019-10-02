package com.zapacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zapacademy.entity.ChatbotUserEntity;

public interface ChatbotUserRepository extends JpaRepository<ChatbotUserEntity, String> {

}
