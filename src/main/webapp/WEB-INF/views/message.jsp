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
	</div>

	<div class="main">

		<div class="postMessage">
			<form role="form" action="/smvc/addMsg" method="POST" id="newMsg">

				<sec:authorize access="isAnonymous()">Name: <br>
					<input type="text" name="name" />
					<br>
				</sec:authorize>

				<sec:authorize access="hasRole('ROLE_USER')">Name: ${pageContext.request.userPrincipal.name} <br>
					<input type="text" name="name"
						value="${pageContext.request.userPrincipal.name}" hidden="true" />
				</sec:authorize>

				<br> Message: <br>
				<textarea name="text" form="newMsg" rows="4" cols="50"></textarea>
				<br>
				<button type="submit">Send</button>
			</form>
		</div>

		<c:forEach var="msg" items="${messages}">
			<div class="customerMsg">
				<div class="userMsg">${msg.name}<div class="dateNews">(${msg.date})</div>
				</div>
				<hr>
				<p>${msg.message}</p>
			</div>
		</c:forEach>

	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
