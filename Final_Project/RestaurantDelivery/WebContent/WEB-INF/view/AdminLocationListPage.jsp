<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Admin Location List</title>
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
					<a class="navbar-brand" href="#">Restaurant Delivery</a>
				</div>
				<div id="collaspe" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="HomePage">Home</a></li>
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

<div class="container">
          <div class="row">
            <div class="col-xs-5 col-xs-offset-1 col-sm-6  col-md-8 col-md-offset-2"> 
			<c:if test="${empty loclist}">
				<h2 class="text-center" style="">
					<font color="red">No Locations found</font>
				</h2>
			</c:if>
			<h2>Location Details</h2>
			<table class="table table-striped" >
				<tr>
					<th>Location ID</th>
					<th>Location Name</th>
					<th>Location Address</th>
					<th>Location Zipcode</th>
					<th>Location Staff Count</th>
					<th>Location Category</th>
					<th>Location Active</th>
				</tr>
				<c:if test="${!empty loclist}">
					<c:forEach items="${loclist}" var="loclist">
						<tr>
							<td align="center">${loclist.id }</td>
							<td>${loclist.locationName }</td>
							<td>${loclist.address }</td>
							<td align="center">${loclist.zipcode }</td>
							<td align="center">${loclist.staffCount }</td>
							<td align="center">${loclist.category }</td>
							<td align="center">${loclist.active }</td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</div>
		</div>
		</div>
		

		<div class="jumbotron">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-6">
						<form action="disableLoc" method="POST">
							<h2 class="text-center">Disable Location</h2>
							<br />
							<div class="form-group">
								<input type="text" class="form-control" name="id"
									placeholder="Location Id">
							</div>
							<br />
							<div class="text-center">
								<button type="submit" class="btn btn-default" id="update"
									value="submit">Disable Locations</button>
							</div>
						</form>
					</div>

					<div class="col-md-6 col-sm-6 col-xs-6">
						<form action="enableLoc" method="POST">
							<h2 class="text-center">Enable Location</h2>
							<br />
							<div class="form-group">
								<input type="text" class="form-control" name="id"
									placeholder="Location Id">
							</div>
							<br />
							<div class="text-center">
								<button type="submit" class="btn btn-default" id="update"
									value="submit">Enable Locations</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="jumbotron">
			<div class="container">
				<div class="row">
					<div class="col-sm-4 col-sm-offset-4">
						<form action="addLoc" method="POST">
							<h2 class="text-center">Add Location</h2>
							<br />
							<div class="form-group">
								<input type="text" class="form-control" name="locationName"
									placeholder="Location Name">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="address"
									placeholder="Address">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="zipcode"
									placeholder="ZipCode">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="staffCount"
									placeholder="Staff Count">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="category"
									placeholder="Category">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="images"
									placeholder="Image URL""">
							</div>
							<br />
							<div class="text-center">
								<button type="submit" class="btn btn-default" id="update"
									value="submit">Add Location</button>
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