<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<!-- container -->

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
						<li class="active"><a href="LoginPage">Login</a></li>
						<li><a href="RegistrationPage">Register</a></li>
					</ul>
				</div>
			</div>
		</nav>

		<!-- Login Menu -->
		<div class="jumbotron">
			<div class="container">
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
						<form action="UserFlow?action=Login" method="post">
							<div>
								<h2 class="text-center">Login Page</h2>
								<h4 class="text-center" style="">
									<font color="red">${errorMessage}</font>
								</h4>
								<h4 class="text-center" style="">${newUserMessage}</h4>
							</div>
							<div class="form-group">
								<input class="form-control" id="user_name"
									placeholder="User Name" type="email" name="userName" />
							</div>
							<div class="form-group">
								<input class="form-control" id="password" placeholder="Password"
									type="password" name="password" />
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-default" id="login"
									name="submit" value="submit">Login</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- /Login Menu -->

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