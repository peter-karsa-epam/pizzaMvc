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
		<c:forEach var="newsitem" items="${news}">
			<div class="news">
				<div class="newsTitle">${newsitem.title}<div class="dateNews">Added:
						${newsitem.date}</div>
				</div>
				<p id="newsContent">${newsitem.content}</p>

			</div>
		</c:forEach>
	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
