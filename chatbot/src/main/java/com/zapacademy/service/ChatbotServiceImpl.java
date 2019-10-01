/**
 * @Description: 
 * @Author: Daniel Beltran
 * @Date: Sep 7, 2019
 */
package com.zapacademy.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapacademy.entity.ChatbotUsuariosEntity;
import com.zapacademy.repository.ChatbotUsuariosRepository;

/**
 * @Description: 
 * @Author: Miguel Alvarado
 * @Date: Sep 7, 2019
 */

@Service
public class ChatbotServiceImpl implements ChatbotService {

	@Autowired
	private ChatbotUsuariosRepository chatbotUsuariosRepository;
	
	@Override
	public boolean buscarNombre(String nombreUsuario) {
		Optional<ChatbotUsuariosEntity> optionalUsuario = chatbotUsuariosRepository.findById(nombreUsuario);
		
		return optionalUsuario.isPresent();
	}
	
	@Override
	public void guardarNombre(String nombreUsuario) {
		
		ChatbotUsuariosEntity entidadUsuario = new ChatbotUsuariosEntity();
		
		entidadUsuario.setNombre(nombreUsuario);
		
		chatbotUsuariosRepository.save(entidadUsuario);
	}
	
	@Override
	public boolean actualizarNombre(String nombreAnterior, String nombreNuevo) {
		
		Optional<ChatbotUsuariosEntity> optionalUsuario = chatbotUsuariosRepository.findById(nombreAnterior);
		
		if(optionalUsuario.isPresent()) {
			
			ChatbotUsuariosEntity entidadUsuario = optionalUsuario.get();
			
			chatbotUsuariosRepository.delete(entidadUsuario);
			
			entidadUsuario.setNombre(nombreNuevo);
			
			chatbotUsuariosRepository.save(entidadUsuario);
			
			return true;
		}
		else {
			return false;
		}
	}
}
