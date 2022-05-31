var element = document.getElementById("form");
var ele = document.getElementById("feedback");

if(element.addEventListener) {
	element.addEventListener("submit",main_validator,true);
} else if(ele.attachEvent) {
	element.attachEvent("onsubmit",main_validator);
}

function main_validator(e) {
	console.log(e)
	e.preventDefault();
	ele.innerHTML = "";
	if(check_name(e.target[0].value) && check_username(e.target[0].value) && check_email(e.target[0].value) && check_password(e.target[0].value)) {
		element.onsubmit();
	}
}

function validate() {
	
		if(document.registration.name.value == "") {
			alert("Please provide your name.");
			document.registration.name.focus();
			return false;
		} else {
			var NAME = document.getElementById("NAME").value;
			alert ("Name: " + NAME);
		}
		
		if(document.registration.username.value == "") {
			alert("Please provide a username.");
			document.registration.username.focus();
			return false;
		} else {
			var USERNAME = document.getElementById("USERNAME").value;
			alert ("Username: " + USERNAME);
		}

		if(document.registration.email.value == "") {
			alert("Please provide your email.");
			document.registration.email.focus();
			return false;
		} else {
			var EMAIL = document.getElementById("email").value;
			alert ("Email: " + EMAIL);
		}

		if(document.registration.password.value == "") {
			alert("Please provide a password.");
			document.registration.password.focus();
			return false;
		} else {
			var PASSWORD = document.getElementById("password").value;
			alert("Password: " + PASSWORD);
		}

}	
	