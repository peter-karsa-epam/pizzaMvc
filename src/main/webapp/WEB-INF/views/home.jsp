<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<title>Luigis' Pizza</title>
</head>
<body>
	<div id="banner">
		<h1>Pizza here soon!</h1>
	</div>
	<div id="menu">
		<table>
			<tr>
				<td><a href="/" target="_self">Home</a></td>
				<td><a href="/" target="_self">Pizzas</a></td>
				<td><a href="/" target="_self">Message</a></td>
				<td><a href="/" target="_self">About</a></td>
			</tr>
		</table>
	</div>
	<div id="main">
		<P>The time on the server is ${serverTime}.</P>
	</div>
	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
