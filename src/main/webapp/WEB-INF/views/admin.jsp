<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src="resources/js/sessionvars.js"></script>
<title>Luigis' Pizza</title>
<meta http-equiv="refresh" content="10">
</head>
<body>
	<div class="headContainer">
		<div class="banner">
			<h1>Luigi's pizza</h1>
			<img id="lologo" alt="logo" src="resources/pizzapic/logo.png"
				height="150px" width="150px">

			<div class="menu">
				<table>
					<tr>
						<td><a href="/smvc/admin" target="_self">Orders</a></td>
						<td><a href="/smvc/adminNews" target="_self">New product
								items & news</a></td>
					</tr>
				</table>
			</div>

			<div class="login">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
			Hi ${pageContext.request.userPrincipal.name}! [ <a
						href="/smvc/logout" target="_self">Logout</a> ]
			</sec:authorize>
			</div>
		</div>
	</div>

	<div class="main">

		<h3>Order List</h3>
		<br> <br>
		<c:forEach var="orderItem" items="${orders}">
			<div class="orderedProd">
				<h6>Ordered products:</h6>
				<ul>
					<c:forEach var="pizzaItem" items="${orderItem.pizzas}">
						<li>${pizzaItem.name}</li>
					</c:forEach>
				</ul>
				<b>Total price: �' ${orderItem.totalCost}</b>
				<h5>Customer Information:</h5>
				<div class="customerInfos">
					Name:
					<p>${orderItem.data.name}</p>
					Address:
					<p>${orderItem.data.address}</p>
					City:
					<p>${orderItem.data.city}</p>
					ZIP-code:
					<p>${orderItem.data.zipcode}</p>
					Phone:
					<p>${orderItem.data.phone}</p>
					Comment:
					<p>${orderItem.data.comment}</p>
					Ordered:
					<h6>${orderItem.date}</h6>
				</div>

				<form name="setDelivered" method="post" action="setDelivered">
					<input type="text" name="name" value="${orderItem.data.name}"
						hidden="true"> <input type="text" name="date"
						value="${orderItem.date}" hidden="true">
					<button type="submit">Set Order Delivered</button>
				</form>

			</div>
		</c:forEach>

	</div>

	<br>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
