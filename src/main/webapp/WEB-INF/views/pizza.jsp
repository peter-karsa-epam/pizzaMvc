<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src="resources/js/sessionvars.js"></script>
<title>Luigis' Pizza</title>
</head>
<body>

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

		<div class="login">
			[ <a href="/smvc/login" target="_self" id="loginLink">Login</a> ]
		</div>

	</div>

	<div class="main">

		<div class="proceed">
			<a class="proceedLink" href="/smvc/order" target="_self">Proceed
				to checkout (${cart.size()} items on list) >></a>
		</div>

		<c:forEach var="pizza" items="${pizzas}">
			<div class="pizzaItem" id="${pizza.id}">
				<h4>${pizza.name}</h4>
				<img src="${pizza.file}" alt="pizza" height="140" width="180">
				<h6>Topping:</h6>
				<p>${pizza.topping}</p>
				<h6>Price:</h6>
				<p>£ ${pizza.price}</p>
				<form id="${pizza.id}" name="input" method="post"
					action="addProduct">
					Quantity: <input type="number" name="quantity" size="4" value="0">
					<input type="text" name="name" value="${pizza.name}" hidden="true">
					<input type="number" name="price" value="${pizza.price}"
						hidden="true">
					<button type="submit">Add</button>
				</form>
			</div>
		</c:forEach>

	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
