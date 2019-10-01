/**
 * @Description: 
 * @Author: Daniel Beltran
 * @Date: Sep 7, 2019
 */
package com.zapacademy.service;

/**
 * @Description: 
 * @Author: Miguel Alvarado
 * @Date: Sep 7, 2019
 */
public interface ChatbotService {
	
	boolean buscarNombre(String nombreUsuario);
	
	void guardarNombre(String nombreUsuario);
	
	boolean actualizarNombre(String nombreAnterior, String nombreNuevo);
}
