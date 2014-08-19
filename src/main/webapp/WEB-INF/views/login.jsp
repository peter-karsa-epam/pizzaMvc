<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src="resources/js/sessionvars.js"></script>
<title>Luigis' Pizza</title>
</head>
<body onload='document.loginForm.username.focus();'>
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

	<div class="main">
		<h3>Login:</h3>
		<div class="loginForm">

			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>

			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>

			<form name="loginForm"
				action="<c:url value='j_spring_security_check' />" method="POST">
				User: <br> <input type="text" name="username" id="loginUser" />
				<br> Password: <br> <input type="password" name="password"
					id="loginPw" /> <br> <input type="submit" value="Login">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
			</form>
		</div>
	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
