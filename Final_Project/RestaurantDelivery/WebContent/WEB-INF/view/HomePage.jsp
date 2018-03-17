
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="container">

		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand">Restaurant Delivery</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="active"><a href="HomePage">Home</a></li>
						<li><a href="MenuItemsPage">Menu</a></li>
						<li><a href="LoginPage">Login</a></li>
						<li><a href="RegistrationPage">Register</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<!-- Navbar -->
		<div>
			<h4 class="text-center">
				<font color="red">${errorMessage}</font>
			</h4>
		</div>
	</div>

	<div class="container">
		<div class="text-center">
			<div class="col-lg-6 col-lg-offset-3">
				<h1>Welcome to Restaurant Delivery</h1>
				<p>Pizza might just be the ultimate delivery meal, so why not up
					the ante a bit? This Pizzeria has the best dough, mozzarella-- both
					made in-house, by hand-- and wood-burning oven quickly established
					it as a force.</p>
					<br/>
				<p>"One cannot think well, Love well, Sleep well if one has not
					DINNED well."</p>
			</div>
		</div>
	</div>
	<!-- /container -->

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
	
</body>
</html>