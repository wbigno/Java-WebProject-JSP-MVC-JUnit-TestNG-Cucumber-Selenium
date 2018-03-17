
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,restaurant.CS.MODEL.ItemModel"%>
<%@page import="java.util.List,restaurant.CS.MODEL.PaymentModel"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<title>Review Order</title>
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
						<li><a href="MenuItemPage">Menu</a></li>
						<li><a href="LogOutPage">Logout</a></li>
						<li><a href="RegularUserPage">User</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<div class="container">
		<div class="d-inline-block">
			<div class="col-md-4">
				<label style="font-size: 30px; text-align: center">Cart
					Items</label>
			</div>
			<div class="d-inline-block">
				<div class="col-md-2 col-md-offset-3">
					<form action="OrderReviewProcessFlow?action=processOrder"
						method="post">
						<button style="width: 150px; height: 50px;"
							class="btn btn-default d-inline-block" id="processOrder"
							type="submit">Process Order</button>
					</form>
				</div>
				<div class="d-inline-block">
					<div class="col-md-2">
						<form action="OrderReviewProcessFlow?action=cancelOrder"
							method="post">
							<button style="width: 150px; height: 50px;"
								class="btn btn-default d-inline-block" id="cancelOrder"
								type="submit">Cancel Order</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<br />
	<br />


	<%
		List<PaymentModel> fees = null;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		if (session.getAttribute("fees") == null) {
			response.sendRedirect("ErrorPageFees");
		} else {
			fees = (List<PaymentModel>) session.getAttribute("fees");
			for (int i = 0; i < fees.size(); i++) {
	%>
	<div class="container">
		<div>
			<form>
				<div class="col-md-4 col-md-offset-7 col-lg-4 col-lg-offset-7">
					<label style="font-size: 20px;" id="subTotal">SubTotal <%=currencyFormat.format(fees.get(i).getTotalPayment())%></label>
				</div>
				<div class="col-md-4 col-md-offset-7 col-lg-4 col-lg-offset-7">
					<label style="font-size: 20px;" id="tax">Total tax amount <%=currencyFormat.format(fees.get(i).getTax())%></label>
				</div>
				<div class="col-md-4 col-md-offset-7 col-lg-4 col-lg-offset-7">
					<label style="font-size: 20px;" id="totalAmount">Total Amount Due <%=currencyFormat.format(fees.get(i).getTotalPurchase())%></label>
				</div>
			</form>
		</div>
	</div>
	<br />
	<br />

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
		<div class="row">
			<div class="col-4">
				<div class="col-6">
					<Form action="OrderDeleteItemFlow?action=deleteItem" method="post">
						<img src=<%=cartlist.get(i).getImages()%>> <label><%=cartlist.get(i).getItemName()%></label>
						<label><%=currencyFormat.format(cartlist.get(i).getPrice())%></label>
						<p><%=cartlist.get(i).getDescription()%></p>
						<div class="col-2">
							<button style="width: 150px; height: 50px;" type="submit"
								class="btn btn-default" id="deleteItem" name="itemId"
								value=<%=cartlist.get(i).getId()%>>Delete from Cart</button>
						</div>
					</Form>
				</div>
			</div>
		</div>
	</div>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;" />
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