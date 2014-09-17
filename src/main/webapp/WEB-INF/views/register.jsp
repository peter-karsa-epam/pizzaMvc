<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/sessionvars.js"></script>
<title>Luigis' Pizza</title>
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="headContainer">
		<div class="banner">
			<h1>Luigi's pizza</h1>
			<img id="lologo" alt="logo" src="resources/pizzapic/logo.png"
				height="150px" width="150px">

			<div class="menu">
				<table>
					<tr>
						<td><a href="/smvc" target="_self">Home</a></td>
						<td><a href="/smvc/pizza" target="_self">Pizzas</a></td>
						<td><a href="/smvc/message" target="_self">Message</a></td>
						<td><a href="/smvc/contact" target="_self">Contact</a></td>
					</tr>
				</table>
			</div>
		</div>
	</div>

	<div class="main">
		<h3>Register:</h3>
		<div class="registerForm">
			<form name="registerForm" action="resgisterNewUser" method="POST">
				Name: <br> <input type="text" name="name"> <br>
				City: <br> <input type="text" name="city"> <br>
				Address: <br> <input type="text" name="address"> <br>
				Zipcode: <br> <input type="text" name="zipcode"> <br>
				Phone: <br> <input type="tel" name="phone"> <br>
				Email: <br> <input type="text" name="email"> <br>
				Username (for login): <br> <input type="text" name="username">
				<br> Password (for login): <br> <input id="pass"
					type="password" name="password"> <span id="passstrength"></span><br>
				<button type="submit">Register</button>
			</form>
		</div>
	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
	<script type="text/javascript">
		$('#pass').keyup(function(e) {
			var bla = $('#pass').val();
			if (bla.length < 6) {
				$('#passstrength').text('Too short (min. 6 characters)');
			} else {
				$('#passstrength').text('');
			}
		});

		$("#pass").on({
			keydown : function(e) {
				if (e.which === 32)
					return false;
			},
			change : function() {
				this.value = this.value.replace(/\s/g, "");
			}
		});
	</script>
</body>
</html>
