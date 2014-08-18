<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src="resources/js/sessionvars.js"></script>
<title>Luigis' Pizza</title>
</head>
<body>

	<div id="banner">
		<h1>Luigi's pizza</h1>
		<img id="lologo" alt="logo" src="resources/pizzapic/logo.png"
			height="150px" width="150px">

		<div id="menu">
			<table>
				<tr>
					<td><a href="/smvc" target="_self">Home</a></td>
					<td><a href="/smvc/pizza" target="_self">Pizzas</a></td>
					<td><a href="/smvc/message" target="_self">Message</a></td>
					<td><a href="/smvc/contact" target="_self">Contact</a></td>
				</tr>
			</table>
		</div>

		<div class="login">
			[ <a href="/smvc/login" target="_self" id="loginLink">Login</a>
			]
		</div>
		
	</div>

	<div class="main">

		<div class="orderList"></div>
		<div class="orderInfoForm">
			<form action="/finalizeOrder" method="POST">
				Name: <br> <input id="user" type="text"> Address: <br>
				<input id="address" type="text"> ZIP-code: <br> <input
					id="zipcode" type="text"> Phone: <br> <input
					id="phone" type="number">
				<button type="submit">Finalize order</button>
			</form>
		</div>

	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
