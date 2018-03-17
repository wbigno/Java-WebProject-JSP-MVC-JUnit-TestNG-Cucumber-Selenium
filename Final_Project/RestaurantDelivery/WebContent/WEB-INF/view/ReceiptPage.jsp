
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,restaurant.CS.MODEL.LocationModel"%>
<%@page import="java.util.List,restaurant.CS.MODEL.ItemModel"%>
<%@page import="java.util.List,restaurant.CS.MODEL.PaymentModel"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<title>Receipt</title>
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
					<a class="navbar-brand" href="#">Restaurant Delivery</a>
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
		<div class="col-md-4 col-lg-4 ">
			<label style="font-size: 30px; text-align: center">Order
				Receipt</label>
		</div>
	</div>
	<br />
	<br />

	<%
		List<LocationModel> loclist = null;
		if (session.getAttribute("delLoc").equals(null)) {
			response.sendRedirect("ErrorPagelocation");
		} else {
			loclist = (List<LocationModel>) session.getAttribute("delLoc");
			for (int i = 0; i < loclist.size(); i++) {
	%>

	<%
		}
		}
	%>

	<%
		List<PaymentModel> fees = null;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		if (session.getAttribute("fees") == null) {
			response.sendRedirect("ErrorPageFees");
		} else {
			fees = (List<PaymentModel>) session.getAttribute("fees");
			for (int i = 0; i < fees.size(); i++) {
	%>
	<form>
		<div class="col-md-4 col-md-offset-7 col-lg-4 col-lg-offset-7">
			<label style="font-size: 20px;">SubTotal <%=currencyFormat.format(fees.get(i).getTotalPayment())%></label>
		</div>
		<div class="col-md-4 col-md-offset-7 col-lg-4 col-lg-offset-7">
			<label style="font-size: 20px;">Total tax amount <%=currencyFormat.format(fees.get(i).getTax())%></label>
		</div>
		<div class="col-md-4 col-md-offset-7 col-lg-4 col-lg-offset-7">
			<label style="font-size: 20px;">Total Amount Due <%=currencyFormat.format(fees.get(i).getTotalPurchase())%></label>
		</div>
		<div class="col-md-4 col-md-offset-7 col-lg-4 col-lg-offset-7">
			<label style="font-size: 17px;">Location: <%=loclist.get(i).getLocationName()%></label>
		</div>
		<div class="col-md-4 col-md-offset-7 col-lg-4 col-lg-offset-7">
			<label style="font-size: 17px;"><%=loclist.get(i).getAddress()%></label>
		</div>
	</form>
	</div>
	</div>
	<%
		}
		}
	%>
	<%
		List<ItemModel> cartlist = null;
		if (session.getAttribute("cartlist") == null) {
			response.sendRedirect("ErrorPageCart");
		} else {
			cartlist = (List<ItemModel>) session.getAttribute("cartlist");
			for (int i = 0; i < cartlist.size(); i++) {
	%>
	<div class="container">
		<div class="float-lg-left">
			<div class="col-md-6 col-lg-6">
				<img src=<%=cartlist.get(i).getImages()%>> <label><%=cartlist.get(i).getItemName()%></label>
				<label><%=currencyFormat.format(cartlist.get(i).getPrice())%></label>
				<p><%=cartlist.get(i).getDescription()%></p>
			</div>
		</div>
	</div>

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