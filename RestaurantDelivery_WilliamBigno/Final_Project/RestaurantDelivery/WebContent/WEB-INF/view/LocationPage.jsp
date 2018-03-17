
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,restaurant.CS.MODEL.LocationModel"%>
<!DOCTYPE html>
<html>
<head>
<title>Location</title>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse ">
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
						<li><a href="MenuItemPage">Menu</a></li>
						<li><a href="LogOutPage">Logout</a></li>
						<li><a href="RegularUserPage">User</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-4">
				<label style="font-size: 30px; text-align: center">Locations</label>
			</div>
			<div class="col-md-2 col-md-offset-4">
				<form action="OrderLocationFlow?action=cancelOrder" method="post">
					<button style="width: 150px; height: 50px;" class="btn btn-default"
						id="cancelOrder" type="submit" name="cancelOrder"
						value="cancelOrder">Cancel Order</button>
				</form>
			</div>
		</div>
	</div>

	<div>
		<br /> <br />
	</div>

	<%
		List<LocationModel> locations = null;
		if (application.getAttribute("loc") == null) {
			response.sendRedirect("OrderFlow");
		} else {
			locations = (List<LocationModel>) application.getAttribute("loc");
			for (int i = 0; i < locations.size(); i++) {
	%>
	<div class="container">
		<div class="row">
			<form action="OrderLocationFlow?action=addLocation" method="post">
				<div class="col-md-3 col-md-offset-1 col-lg-3 col-lg-offset-1">
					<img src=<%=locations.get(i).getImage()%>>
				</div>
				<div class="col-md-4 col-lg-4">
					<h4>
						Location: <span><%=locations.get(i).getLocationName()%></span>
					</h4>
					<h5>
						<%=locations.get(i).getAddress()%>
						<%=locations.get(i).getStaffCount()%>
						<%=locations.get(i).getZipcode()%>
					</h5>
				</div>
				<div class="col-md-1 col-lg-1">
					<button style="width: 150px; height: 50px;" type="submit"
						class="btn btn-default" id="locId" name="locId"
						value=<%=locations.get(i).getId()%>>Select Location</button>
				</div>
			</form>
		</div>
	</div>
	<hr style="height:1px;border:none;color:#333;background-color:#333;" />
	<br />
	<br />
	<%
		}
		}
	%>

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