console.log("Cargando codigo JavaScript");

function asignaEvento(){
	var mensajeAEnviar = document.getElementById("mensajeAEnviar");

	mensajeAEnviar.addEventListener("keyup", function(event) {
			
			// el codigo 13 representa la tecla Enter
			if (event.keyCode === 13) {
				EnviarMensaje(mensajeAEnviar.value);
			}
	});
	obtenerTipoDeBackEnd();
}

function obtenerTipoDeBackEnd(){
	$.ajax({
		beforeSend : function (){
			console.log("Preguntando al backEnd que tipo de aplicacion es....");
		},
		url: '/cgi-bin/chatbot_imprime_tipo_app.pl',
		type: "GET",
		success: function (respuesta) {
			console.log("recibi: " + JSON.stringify(respuesta) );
			document.getElementById("backendSource").innerHTML = respuesta.valor;
		},
		error: function() {
			alert("no pude completar la comunicacion!!");
		},
		complete: function() {
			console.log("Ya termine de cargar el tipo de aplicacion");
		}
	});
}

function EnviarMensaje(mensajeAEnviar){
	console.log("Enviando mensaje: " + mensajeAEnviar);
	$.ajax({
		beforeSend : function (){
			console.log("Espera un momento, enviando mensaje....");
			document.getElementById("EnviandoStatusTag").innerHTML = "...";
			document.getElementById("aqui_va_la_respuesta").innerHTML += "<div class='estilo_envia'>" + mensajeAEnviar + incluirFechaYHoraActual() + "</div>";
		},
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		url: '/cgi-bin/chatbot_controller.pl?mensaje=' + mensajeAEnviar,
		type: "GET",
		dataType: "json",
		async: false,
		success: function (respuesta) {
			console.log("Me llego: " + JSON.stringify(respuesta) );
			var emoticon = '';
			if(respuesta.emoticon != ''){
				emoticon = "<img src='img/emoticon_" + respuesta.emoticon + ".png'>";
			}
			document.getElementById("aqui_va_la_respuesta").innerHTML += "<div class='estilo_recibe'>" + respuesta.texto + " " + emoticon + incluirFechaYHoraActual() +"</div>";
			scrollToBottom( document.getElementById("aqui_va_la_respuesta") );
		},
		error: function() {
			alert("no pude completar la comunicacion!!");
		},
		complete: function() {
			document.getElementById("EnviandoStatusTag").innerHTML = "";
			document.getElementById("mensajeAEnviar").value = "";
			console.log("Ya termine de coordinar los mensajes!!");
		}
	});
}

function incluirFechaYHoraActual(){
	return " <span class='estilo_fecha_hora'>" + obtenerFechaYHoraActual() + "</span>";
}

function obtenerFechaYHoraActual(){
	var today = new Date();
	var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
	var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
	//return date + ' ' + time;
	return time;
}

function scrollToBottom(e) {
  //e.scrollTop = e.scrollHeight - e.getBoundingClientRect().height;
  e.scrollTop = e.scrollHeight;
}

console.log("JavaScript Listo");