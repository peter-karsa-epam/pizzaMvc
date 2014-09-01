var timeSec = setInterval(timeFunc, 1000);
var sec = 15;

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

$('#pass').keyup(function(e) {
    var strongRegex = new RegExp("^(?=.{8,})(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\W).*$", "g");
    var mediumRegex = new RegExp("^(?=.{7,})(((?=.*[A-Z])(?=.*[a-z]))|((?=.*[A-Z])(?=.*[0-9]))|((?=.*[a-z])(?=.*[0-9]))).*$", "g");
    var enoughRegex = new RegExp("(?=.{6,}).*", "g");
    if (false == enoughRegex.test($(this).val())) {
            $('#passstrength').html('More Characters');
    } else if (strongRegex.test($(this).val())) {
            $('#passstrength').className = 'ok';
            $('#passstrength').html('Strong!');
    } else if (mediumRegex.test($(this).val())) {
            $('#passstrength').className = 'alert';
            $('#passstrength').html('Medium!');
    } else {
            $('#passstrength').className = 'error';
            $('#passstrength').html('Weak!');
    }
    return true;
});
