
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List,restaurant.CS.MODEL.ItemModel"%>
<%@page import="java.util.List,restaurant.CS.MODEL.ReviewModel"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<!DOCTYPE html>
<html>
<head>
<title>Review</title>
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
						<li><a href="LogOutPage">Logout</a></li>
						<li><a href="RegularUserPage">User</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>

	<div class="container">
		<nav class="navbar sticky-top navbar-light bg-faded ">
			<div class="container-center">
				<div class="navbar-nav.navbar-center">
					<label style="font-size: 30px; text-align: center">Product
						Review</label>
				</div>
			</div>
		</nav>
	</div>

	<%
		List<ItemModel> reviewItem = null;
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		if (session.getAttribute("reviewItem").equals(null)) {
			response.sendRedirect("OrderFlow");
		} else {
			reviewItem = (List<ItemModel>) session.getAttribute("reviewItem");
			for (int i = 0; i < reviewItem.size(); i++) {
				int itemId = reviewItem.get(i).getId();
	%>
	<div class="container">
		<div class="row">
			<div class="col-sm-8 col-md-8 col-lg-8">
				<img src=<%=reviewItem.get(i).getImages()%>>
				<h3>
					<label><%=reviewItem.get(i).getItemName()%></label> <label><%=currencyFormat.format(reviewItem.get(i).getPrice())%></label>
				</h3>
				<h4>
					<p><%=reviewItem.get(i).getDescription()%></p>
				</h4>
			</div>
		</div>
		<div class="row">
			<Form action="OrderItemReviewFlow?action=submitReview" method="post">
				<div class="col-sm-8 col-md-8 col-lg-8">
					<label for="comment">Product Review:</label>
					<textarea class="form-control" rows="3" id="review"
						name="reviewDetails" required></textarea>
					<button style="width: 150px; height: 50px;" type="submit"
						class="btn btn-default" id="itemId" name="itemId"
						value=<%=reviewItem.get(i).getId()%>>Submit Review</button>
				</div>
			</Form>
		</div>
	</div>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;" />

	<%
		List<ReviewModel> reviewList = null;
				if (application.getAttribute("reviewList").equals(null)) {
					response.sendRedirect("ErrorPageReview");
				} else {
					reviewList = (List<ReviewModel>) application.getAttribute("reviewList");
					for (int r = 0; r < reviewList.size(); r++) {
						if (reviewList.get(r).getItemId() == itemId) {
	%>
	<div class="container">
		<div class="col-sm-4 col-md-4 col-lg-4">
			<label>Product Review:</label>
			<p><%=reviewList.get(r).getReviewDetails()%>
			</p>
		</div>
	</div>
	<br/>
	<hr
		style="height: 1px; border: none; color: #333; background-color: #333;" />
	<%
		}
					}
				}
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