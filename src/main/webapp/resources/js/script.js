var timeSec = setInterval(timeFunc, 1000);

function timeFunc() {
	document.getElementById().innerHTML = new Date();
}

function addPizza(f) {
	alert(f.elements[0].value + " amount \n" + f.elements[1].value
			+ " name \n " + f.elements[2].value * f.elements[0].value
			+ " pound price \n");
}

function formSubmit() {
	document.getElementById("logoutForm").submit();
}
