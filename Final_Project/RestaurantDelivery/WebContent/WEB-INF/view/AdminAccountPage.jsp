
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Details</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

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
			<div id="collaspe" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/">Home</a></li>
					<li><a href="LogOutPage">Logout</a></li>
					<li class="active"><a href="AdminAccountPage">Admin</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						role="button" aria-haspopup="true" aria-expanded="false">Admin
							Reports</a>
						<div class="dropdown-menu">
							<a class="dropdown-item" href="AdminUserListPage">User
								Edit/Updates</a><br /> <a class="dropdown-item"
								href="AdminLocationListPage">Location Updates</a><br /> <a
								class="dropdown-item" href="AdminOrderPage">Order Report</a><br />
							<a class="dropdown-item" href="AdminSellItemsListPage">Item
								Updates</a><br />
						</div></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Main component for a primary marketing message or call to action -->
	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="col-sm-4 col-sm-offset-4">
					<form action="updateFullUser" method="POST">
						<h2 class="text-center">Update Admin Details</h2>
						<br />
						<div class="form-group">
							<input type="text" class="form-control" name="firstName"
								placeholder="First Name" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="lastName"
								placeholder="Last Name" required>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" name="email"
								placeholder="Email" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password"
								placeholder="Password" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="address"
								placeholder="Street Address" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="zipcode"
								placeholder="ZipCode" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="phone"
								placeholder="Phone (7 digits no dashes)" required>
						</div>
						<br />
						<div class="text-center">
							<button type="submit" class="btn btn-default" id="update"
								value="submit">Update</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


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