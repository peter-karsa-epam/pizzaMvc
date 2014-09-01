<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
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
			<sec:authorize access="isAnonymous()">
			[ <a href="/smvc/register" target="_self">Register</a> ] 
			[ <a href="/smvc/login" target="_self">Login</a> ]
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
			Hi ${pageContext.request.userPrincipal.name}! [ <a
					href="/smvc/logout" target="_self">Logout</a> ]
			</sec:authorize>
		</div>

	</div>

	<div class="main">

		<div class="proceed">
			<sec:authorize access="hasRole('ROLE_USER')">
				<form action="postUserNameLoggedIn" method="POST">
					<input id="user" type="text" name="username"
						value="${pageContext.request.userPrincipal.name}" hidden="true">
					<button type="submit">Proceed to checkout (${cart.size()}
						items on list) >></button>
				</form>
			</sec:authorize>

			<sec:authorize access="isAnonymous()">
				<a class="proceedLink" href="/smvc/order" target="_self">Proceed
					to checkout (${cart.size()} items on list) >></a>
			</sec:authorize>
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
					<input type="text" name="name" value="${pizza.name}" hidden="true" readonly="readonly">
					<input type="number" name="price" value="${pizza.price}"
						hidden="true" readonly="readonly">
					<button type="submit">Add</button>
				</form>
			</div>
		</c:forEach>

	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
