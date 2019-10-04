function validarLogin(){
    let usuario = document.form.usuario.value;
    let password = document.form.password.value;
    
    if(usuario==null || usuario==""){
        alert("El nombre de usuario es requerido");
        return false;
    }
    if(password== null || password==""){
        alert("La contraseña es requerida");
        return false;
    }
    
}

let form = document.querySelector(".registerForm");
form.addEventListener('submit', checkRegister);

function checkRegister(e){
	
	let name = form.name.value;
	let email = form.email.value;
    let password = form.password.value;
	let validatePassword = form.validatePassword.value;
	let validationFailed = false;
	
	if(email==null || email==""){
		alert("El email es requerido");
		e.preventDefault();
		return false;
    }
    if(name==null || name==""){
		alert("El nombre de usuario es requerido");
		e.preventDefault();
		return false;
    }
    if(password== null || password==""){
		alert("La contraseña es requerida");
		e.preventDefault();
		return false;
    }
    if(validatePassword== null || validatePassword==""){
		alert("La contraseña es requerida");
		e.preventDefault();
		return false;
    }
    if(validatePassword !== password){
		alert("La contraseña no coinciden");
		e.preventDefault();
		return false;
	}  
	
	if(validationFailed){
		return true;
	}
}

function validarRegistro(){
    let usuario = document.form.usuario.value;
    let password = document.form.password.value;
    let valiarPassword = document.form.validarPassword.value;
    let email = document.form.email.value;
    console.log("Hola");
    if(email==null || email==""){
        alert("El email es requerido");
        return false;
    }
    if(usuario==null || usuario==""){
        alert("El nombre de usuario es requerido");
        return false;
    }
    if(password== null || password==""){
        alert("La contraseña es requerida");
        return false;
    }
    if(valiarPassword== null || valiarPassword==""){
        alert("La contraseña es requerida");
        return false;
    }
    if(valiarPassword !== password){
        alert("La contraseña no coinciden");
        return false;
    }  
}

