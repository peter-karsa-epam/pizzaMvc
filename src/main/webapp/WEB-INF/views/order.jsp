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
			[ <a href="/smvc/login" target="_self">Login</a> ]
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_USER')">
			Hi ${pageContext.request.userPrincipal.name}! [ <a
					href="/smvc/logout" target="_self">Logout</a> ]
			</sec:authorize>
		</div>

	</div>

	<div class="main">

		<div class="orderList">

			<table class="orderListTable">
				<c:forEach var="orderedItem" items="${cart}">
					<tr>
						<td>${orderedItem}</td>
						<td class="price">${orderedItem.price}</td>
						<td class="remove">x</td>
					</tr>
				</c:forEach>
			</table>
			<div class="total">£'${totalPrice}</div>
		</div>

		<div class="orderInfoForm">
			<sec:authorize access="isAnonymous()">
				<form action="finalizeOrder" method="POST" id="finalizeOrder"
					role="form">
					Name: <br> <input id="user" type="text" name="name"> <br>
					Address: <br> <input id="city" type="text" name="address">
					<br> City: <br> <input id="address" type="text"
						name="city"> <br> ZIP-code: <br> <input
						id="zipcode" type="text" name="zipcode"> <br> Phone:
					<br> <input id="phone" type="number" name="phone"> <br>
					Comment: <br>
					<textarea name="comment" form="finalizeOrder" rows="4" cols="50"></textarea>
					<br>
					<button type="submit">Finalize order</button>
				</form>
			</sec:authorize>

			<sec:authorize access="hasRole('ROLE_USER')">
				<form action="finalizeOrder" method="POST" id="finalizeOrder"
					role="form">
					Name: <br> <input id="user" type="text" name="name"
						value="${user.name}"> <br> Address: <br> <input
						id="city" type="text" name="address" value="${user.address}">
					<br> City: <br> <input id="address" type="text"
						name="city" value="${user.city}"> <br> ZIP-code: <br>
					<input id="zipcode" type="text" name="zipcode" ${user.zipcode}>
					<br> Phone: <br> <input id="phone" type="number"
						name="phone" value="${user.phone}"> <br> Comment: <br>
					<textarea name="comment" form="finalizeOrder" rows="4" cols="50"></textarea>
					<br>
					<button type="submit">Finalize order</button>
				</form>
			</sec:authorize>
			<hr>
			<a class="proceedLink" href="/smvc/pizza" target="_self">Back to
				pizzas!</a>
		</div>

	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
