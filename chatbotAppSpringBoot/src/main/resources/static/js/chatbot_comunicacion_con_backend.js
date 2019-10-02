sendMessage();
backendType();

function sendMessage(){
	let message = document.querySelector("#mensajeAEnviar");
	
	message.addEventListener('keyup', event => {
		event.keyCode === 13 ? sentMessage(message.value) : '';
	});
}

function backendType(){
	$.ajax({
		url: '/app_type',
		type: "GET",
		success: function (respuesta) {
			console.log("recibi: " + JSON.stringify(respuesta) );
			document.getElementById("backendSource").innerHTML = respuesta.valor;
		},
		error: function() {
			alert("no pude completar la comunicacion!!");
		}
	});
}

function sentMessage(message){
	$.ajax({
		beforeSend : function (){
			document.getElementById("EnviandoStatusTag").innerHTML = "...";
			document.getElementById("aqui_va_la_respuesta").innerHTML += "<div class='estilo_envia'>" + message + getDate() + "</div>";
			
		},
		headers: { 
	        'Accept': 'application/json',
	        'Content-Type': 'application/json' 
	    },
		url: '/chatbot_controller?mensaje=' + message,
		type: "GET",
		dataType: "json",
		async: false,
		success: function (respuesta) {
			console.log("Me llego: " + JSON.stringify(respuesta) );
			
			var emoticon = '';
			if(respuesta.emoticon != ''){
				emoticon = "<img src='img/emoticon_" + respuesta.emoticon + ".png'>";
			}
			document.getElementById("aqui_va_la_respuesta").innerHTML += "<div class='estilo_recibe'>" + respuesta.text + " " + emoticon + getDate() + "</div>";
			scrollToBottom( document.getElementById("aqui_va_la_respuesta") );
		},
		error: function() {
			alert("no pude completar la comunicacion!!");
		},
		complete: function() {
			document.getElementById("EnviandoStatusTag").innerHTML = "";
			document.querySelector("#mensajeAEnviar").value = "";
		}
	});
}

function scrollToBottom(e) {
  //e.scrollTop = e.scrollHeight - e.getBoundingClientRect().height;
  e.scrollTop = e.scrollHeight;
}
getDate();
function getDate(){
	let today = new Date();
	//let date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
	let time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
	return `<span class="estilo_fecha_hora">${time}</span>`;
}