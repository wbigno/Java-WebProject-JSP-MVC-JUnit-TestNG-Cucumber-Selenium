
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,restaurant.CS.MODEL.ItemModel"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<title>Menu</title>
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
						<li><a href="HomePage">Home</a></li>
						<li class="active"><a href="MenuItemPage">Menu</a></li>
						<li><a href="LogOutPage">Logout</a></li>
						<li><a href="RegularUserPage">User</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<label style="font-size: 30px; text-align: center">Menu
					Items</label>
				<h4 class="text-center" style="">
					<font color="red">${errorMessage}</font>
				</h4>
			</div>
			<div class="col-md-2 col-md-offset-4">
				<form class="navbar-nav.navbar-center"
					action="OrderProcessFlow?action=processOrder" method="post">
					<button style="width: 150px; height: 50px;" class="btn btn-default"
						id="processOrder" type="submit" name="processOrder"
						value="processOrder">Process Order</button>

				</form>
			</div>
		</div>
	</div>

	<%
		List<ItemModel> itemlist = null;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		if (application.getAttribute("list").equals(null)) {
			response.sendRedirect("OrderFlow");
		} else {
			itemlist = (List<ItemModel>) application.getAttribute("list");
			for (int i = 0; i < itemlist.size(); i++) {
	%>
	<div class="container">
		<div class="row">
			<div class="col-4">
				<img src=<%=itemlist.get(i).getImages()%>>
				<h4>
					<label><%=itemlist.get(i).getItemName()%></label> 
					<label><%=currencyFormat.format(itemlist.get(i).getPrice())%></label>
				</h4>
				<h5>
					<p><%=itemlist.get(i).getDescription()%></p>
				</h5>
			</div>
			<div class="row">
				<div class="col-md-4">
					<label for="comment">Special Delivery Comment:</label>
					<textarea class="form-control" rows="3" id="comment" name="comment"></textarea>
				</div>
			</div>
			<br />
			<div class="row">
				<Form action="OrderAddItemFlow?action=addCart" method="post">
					<div class="col-md-2">
						<button style="width: 150px; height: 50px;" type="submit"
							class="btn btn-default" id="addCart" name="itemId"
							value=<%=itemlist.get(i).getId()%>>Add to Cart</button>
					</div>
				</Form>
				<Form action="OrderItemReviewFlow?action=reviewItem" method="post">
					<div class="col-md-2">
						<button style="width: 150px; height: 50px;" type="submit"
							class="btn btn-default" id="reviewItem" name="reviewItem"
							value=<%=itemlist.get(i).getId()%>>Submit Review</button>
					</div>
				</Form>
			</div>
		</div>
	</div>
	</div>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;" />
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