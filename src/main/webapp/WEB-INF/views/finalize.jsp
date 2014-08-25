<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
			<sec:authorize access="isAnonymous()">
			[ <a href="/smvc/login" target="_self">Login</a> ]
			</sec:authorize>
			<sec:authorize access="hasRole('user')">
			Welcome
			[ <a href="/smvc/login" target="_self">Logout</a> ]
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

		<div class="customerInfos">
			Name:
			<p>${orderData.name}</p>
			Address:
			<p>${orderData.address}</p>
			City:
			<p>${orderData.city}</p>
			ZIP-code:
			<p>${orderData.zipcode}</p>
			Phone:
			<p>${orderData.phone}</p>
			Comment:
			<p>${orderData.comment}</p>
			<a class="click-me" href="/smvc/thanks">Click me</a>

		</div>

	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
