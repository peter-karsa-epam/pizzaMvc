<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="true"%>
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<script type="text/javascript" src="resources/js/sessionvars.js"></script>
<title>Luigis' Pizza</title>
<meta http-equiv="refresh" content="15;url=/smvc/" />
<script type="text/javascript">
	var timing = setInterval(doStuff, 1000);
	var sec = 15;

	function doStuff() {
		if (sec != 0) {
			sec -= 1;
			document.getElementById("timeBefore").innerHTML = sec;
		} else {
			timing = null;
		}
	}
</script>
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
		</div>

		<div class="login">
			<sec:authorize access="isAnonymous()">
			[ <a href="/smvc/register" target="_self">Register</a> ] 
			[ <a href="/smvc/login" target="_self">Login</a> ]
			</sec:authorize>
			<sec:authorize access="hasRole('user')">
			Welcome
			[ <a href="/smvc/login" target="_self">Logout</a> ]
			</sec:authorize>
		</div>

	</div>

	<div class="main">

		<p>
			Thank you, for your order! It will arrive in 30-45 minutes!
			<it>(Don't forget that after 45 minutes the pizza is on the
			house!)</it>
		</p>
		<hr>
		<a class="click-me" href="/smvc/pizza" target="_self">&lt;&lt;
			Back to more pizzas!</a> <br> <br> Redirecting you to home page
		in...
		<p id="timeBefore">15</p>

	</div>

	<script type="text/javascript" src="resources/js/script.js"></script>
</body>
</html>
