package com.zapacademy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chatbot_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatbotUserEntity {
	@Id
	@Column(name = "nombre")
	private String name;
}
