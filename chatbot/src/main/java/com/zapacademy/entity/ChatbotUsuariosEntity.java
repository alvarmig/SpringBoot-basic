/**
 * @Description: 
 * @Author: Daniel Beltran
 * @Date: Sep 7, 2019
 */
package com.zapacademy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Description: 
 * @Author: Miguel Alvarado
 * @Date: Sep 7, 2019
 */

@Entity
@Table(name = "chatbot_usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatbotUsuariosEntity {
	
	@Id
	@Column(name = "nombre")
	private String nombre;
}
