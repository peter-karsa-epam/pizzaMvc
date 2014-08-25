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
		<h4>Luigi's pizza ltd.</h4>
		<div class="firmDetails">
			<p>Address: Beaufort St Bristol, City of Bristol BS5 0SQ, UK</p>
			<p>Tel.: +004401100101010111</p>
			<p>
				Email: <a href="mailto:pizza@luigi.co.uk" target="_top"
					id="mailLink">pizza@luigi.co.uk</a>
			</p>
			<P>Open: every day from 10h-22h</P>
			<p>Founded: 1999</p>
		</div>
	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
