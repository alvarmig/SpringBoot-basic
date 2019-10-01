/**
 * @Description: 
 * @Author: Daniel Beltran
 * @Date: Sep 7, 2019
 */
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

import com.zapacademy.dto.responses.RespuestaResponse;
import com.zapacademy.service.ChatbotService;

/**
 * @Description: 
 * @Author: Daniel Beltran
 * @Date: Sep 7, 2019
 */

@RestController
@RequestMapping( value = "/cgi-bin" )
public class ChatbotController {
	
	@Autowired
	private ChatbotService chatbotService;
	
	@GetMapping( value="/chatbot_imprime_tipo_app.pl", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getTipoAplicacion() {
        
		return ResponseEntity.ok("{ \"valor\": \"JAVA :P\" }");
    }
	
	
	@GetMapping( value="/chatbot_controller.pl", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespuestaResponse> analizaMensaje(@RequestParam(value = "mensaje") String mensaje) {
        
		RespuestaResponse respuestaResponse = new RespuestaResponse();
		
		respuestaResponse.setTexto("No entendi lo que dijiste!");
		respuestaResponse.setEmoticon("pensativo");
		
		if( mensaje.toLowerCase().startsWith("hola") ) {
			
			respuestaResponse.setTexto("Que tal, como te llamas?");
			respuestaResponse.setEmoticon("");	
		}
		else if( mensaje.toLowerCase().startsWith("me llamo ") ){
			
			Pattern pattern = Pattern.compile("me llamo (\\w+)");
			Matcher matcher = pattern.matcher(mensaje);
			
			if (matcher.matches()) {
				
				String nombreUsuario = matcher.group(1);
				
				buscaNombre(nombreUsuario, respuestaResponse);
			}
		}
		else if(mensaje.toLowerCase().contains("me cambie de nombre")){
			
			respuestaResponse.setTexto("orale!!!, ahora como te llamas?");
			respuestaResponse.setEmoticon("sorprendido");
		}
		else {
			
			Pattern pattern = Pattern.compile("me llamaba (\\w+) y ahora me llamo (\\w+)");
			Matcher matcher = pattern.matcher(mensaje);
			
			if (matcher.matches()) {
				String nombreAnterior = matcher.group(1);
				String nombreNuevo    = matcher.group(2);
				
				actualizaNombre(nombreAnterior, nombreNuevo, respuestaResponse);
			}
		}
		
		return ResponseEntity.ok(respuestaResponse);
    }
	
	private RespuestaResponse buscaNombre(String nombreUsuario, RespuestaResponse respuestaResponse) {
		
		if( chatbotService.buscarNombre(nombreUsuario) ) {
			
			respuestaResponse.setTexto("Regresaste!!, como has estado?");
			respuestaResponse.setEmoticon("encantado");
		}
		else {
			chatbotService.guardarNombre(nombreUsuario);
			
			respuestaResponse.setTexto("mucho gusto " + nombreUsuario + ", como estas?");
			respuestaResponse.setEmoticon("abrazo");
		}
		return respuestaResponse;
	}
	
	private RespuestaResponse actualizaNombre(String nombreAnterior, String nombreNuevo, RespuestaResponse respuestaResponse) {
		
		if( chatbotService.actualizarNombre(nombreAnterior, nombreNuevo) ) {
			
			respuestaResponse.setTexto("Listo " + nombreNuevo + ", ya lo actualice!");
			respuestaResponse.setEmoticon("listo");
		}
		else {
			respuestaResponse.setTexto("haaa, ese nombre ni lo tenia!");
			respuestaResponse.setEmoticon("nelpastel");
		}
		return respuestaResponse;
	}
}
