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
		<img id="lologo" alt="logo" src="resources/pizzapic/logo.png" height="150px" width="150px">
	<div id="menu">
		<table>
			<tr>
				<td><a href="/smvc" target="_self">Home</a></td>
				<td><a href="/smvc/pizza" target="_self">Pizzas</a></td>
				<td><a href="/smvc/message" target="_self">Message</a></td>
				<td><a href="/smvc/contact" target="_self">Contact</a></td>
				<td><a href="/smvc/admin" target="_self">Login</a></td>
			</tr>
		</table>
	</div>
	</div>
	<div id="main">
		<P>The time on the server is ${serverTime}.</P>
	</div>
	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>