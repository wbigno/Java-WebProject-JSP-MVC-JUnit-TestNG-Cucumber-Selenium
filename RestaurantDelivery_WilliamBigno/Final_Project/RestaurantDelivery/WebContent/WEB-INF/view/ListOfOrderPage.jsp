 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prior Orders</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
<div class="container">
      <nav class="navbar navbar-inverse ">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span> 
            </button>
            <a class="navbar-brand" >Restaurant Delivery</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
              <li><a href="HomePage">Home</a></li>
              <li><a href="MenuItemsPage">Menu</a></li>
              <li><a href="LogOutPage">Logout</a></li>
              <li><a href="RegularUserPage">User</a></li>
            </ul>
          </div>
        </div>
      </nav> 
    </div>
  
          <div class="container">
          <div class="row">
            <div class="col-xs-5 col-xs-offset-2 col-sm-6  col-md-8 col-md-offset-2"> 
				<c:if test="${empty orderListByUser}">
       				<h2 class="text-center" style="strong"><font color="red">No Orders Found</font></h2>
    			</c:if>
   					<h2>Order Details</h2>
						<table class="table table-striped" >
							<tr>
								<th>Order ID</th>
								<th>Order Date</th>
								<th>Location Id</th>
								<th>Order Location Name</th>
								<th>Order Item ID</th>
								<th>Order Item Name</th>
								<th>Order Total Payment</th>
							</tr>
		 		<c:if test="${!empty orderListByUser}">
        			<c:forEach items="${orderListByUser}" var="orders">
				        <tr>
					        <td>${orders.orderId }</td>
					        <td>${orders.orderDate }</td>
					        <td>${orders.locationId }</td>
					        <td>${orders.locationName }</td>
					        <td>${orders.itemId }</td>
					        <td>${orders.itemName }</td>
					        <td>${orders.totalPayment }</td>
				        </tr>
					</c:forEach>
				</c:if>
					</table>
			</div>
     	</div>
   	</div>
	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>