<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src="resources/js/sessionvars.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".pizzaItem").mouseenter(function() {
			$("#" + this.id + " .hiddenPizza").show(500);
		});
		$(".pizzaItem").mouseleave(function() {
			$("#" + this.id + " .hiddenPizza").hide(500);
		});
	});
</script>
<title>Luigis' Pizza</title>
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
		<div class="addProduct">
			<h3>Add pizza to productlist</h3>
			<form action="/smvc/addPizza" method="POST"
				enctype="multipart/form-data">
				Name: <br> <input type="text" name="name" /> <br>
				Topping: <br> <input type="text" name="toppings" /> <br>
				Price: <br> <input type="number" name="price" step="any" /> <br>
				Picture: <br> <input type="file" name="image" /> <br> <input
					type="submit" value="Add product">
			</form>
		</div>

		<div class="removeProduct">
			<h3>Remove pizza from productlist</h3>

			<c:forEach var="pizza" items="${pizzas}">
				<div class="pizzaItem" id="${pizza.id}">
					<h4>${pizza.name}</h4>
					<div class="hiddenPizza" id="${pizza.id}">
						<img src="${pizza.file}" alt="pizza" height="140" width="180">
						<form id="${pizza.id}" name="input" method="post"
							action="modifyProduct">
							Name: <br>
							<input type="text" name="name" value="${pizza.name}"> <br>
							Topping: <br>
							<input type="text" name="topping" value="${pizza.topping}">
							<br> Price: <br>
							<input type="number" name="price" value="${pizza.price}"
								step="any"><br>
							<button type="submit">Modify</button>
						</form>
						<form id="${pizza.id}" name="input" method="post"
							action="removeProduct">
							<input type="text" name="name" value="${pizza.name}"
								hidden="true" readonly="readonly">
							<button type="submit">Remove</button>
						</form>
					</div>
				</div>
			</c:forEach>

		</div>

		<div class="addNewsForm">
			<h3>Add news to homepage</h3>
			<form action="/smvc/addNews" method="POST" id="addNewsForm">
				Title: <br> <input type="text" name="newsTitle" /> <br>
				Content: <br>
				<textarea name="newsContent" form="addNewsForm" rows="4" cols="50"></textarea>
				<br> <input type="submit" value="Add to news">
			</form>
		</div>

	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
