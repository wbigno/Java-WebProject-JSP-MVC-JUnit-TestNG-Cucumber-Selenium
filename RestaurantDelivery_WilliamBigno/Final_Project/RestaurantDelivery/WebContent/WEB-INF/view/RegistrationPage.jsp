
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>User Details</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">

		<!-- Static navbar -->
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
						<li><a href="HomePage">Home</a></li>
						<li><a href="MenuItemsPage">Menu</a></li>
						<li><a href="LoginPage">Login</a></li>
						<li class="active"><a href="RegistrationPage">Register</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<div class="container">
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
						<h3 style="">
							<font color="red">${errorMessage}</font>
						</h3>
						<form action="UserFlow?action=Registration" method="post">
							<h2 class="text-center">User Details</h2>
							<br />
							<div class="form-group">
								<input type="text" class="form-control" id="firstName"
									name="firstName" placeholder="First Name" required>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="lastName"
									name="lastName" placeholder="Last Name" required>
							</div>
							<div class="form-group">
								<input type="email" class="form-control" id="email" name="email"
									placeholder="Email" required>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Password" required>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password2"
									name="password2" placeholder="Confirm Password" required>
							</div>
							<div class="form-group" class="text-center">
								<label style="color: #8e8e8e" class="form-control">
									Gender: </label> <input class="text-center" type="radio" id="mgender"
									name="gender" value="male" required> Male <input
									class="text-center" type="radio" id="fgender" name="gender"
									value="female" required> Female
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="address"
									name="address" placeholder="Street Address" required>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="zipCode"
									name="zipCode" placeholder="Zipcode" required>
							</div>
							<div class="form-group">
								<input type="text" class="form-control" id="phone" name="phone"
									placeholder="Phone" required>
							</div>

							<br />
							<div class="text-center">
								<button type="submit" class="btn btn-default" id="Registration"
									value="submit" name="submit">Register</button>
							</div>
						</form>
					</div>
				</div>
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