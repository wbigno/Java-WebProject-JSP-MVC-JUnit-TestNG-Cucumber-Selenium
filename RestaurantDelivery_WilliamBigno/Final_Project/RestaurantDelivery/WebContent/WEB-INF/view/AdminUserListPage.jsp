 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
  <title>Admin User Update</title>
 <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>
  <div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">Restaurant Delivery</a>
          </div>
          <div id="collaspe" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
              <li><a href="HomePage">Home</a></li>
              <li><a href="LogOutPage">Logout</a></li>
              <li class="active"><a href="AdminAccountPage">Admin</a></li>
               <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Admin Reports</a>
                <div class="dropdown-menu">
                  <a class="dropdown-item" href="AdminUserListPage">User Edit/Updates</a><br/>
                  <a class="dropdown-item" href="AdminLocationListPage">Location Updates</a><br/>
                  <a class="dropdown-item" href="AdminOrderPage">Order Report</a><br/>
                  <a class="dropdown-item" href="AdminSellItemsListPage">Item Updates</a><br/>
        		</div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
</div>

	<div class="container">
          <div class="row">
            <div class="col-xs-5  col-sm-6 col-sm-offset-1 col-md-8 col-md-offset-2"> 
				<c:if test="${empty userlist}">
       				<h2 class="text-center" style="strong"><font color="red">No Users found</font></h2>
    			</c:if>
   					<h2>User Details</h2>
						<table class="table table-striped" >
							<tr>
								<th>User ID</th>
								<th>User First Name</th>
								<th>User Last Name</th>
								<th>User Gender</th>
								<th>User Address</th>
								<th>User ZipCode</th>
								<th>User Phone</th>
								<th>User Email</th>
								<th>User Admin</th>
							</tr>
		 		<c:if test="${!empty userlist}">
        			<c:forEach items="${userlist}" var="user">
				        <tr>
					        <td >${user.id }</td>
					        <td >${user.firstName }</td>
					        <td >${user.lastName }</td>
					        <td >${user.gender }</td>
					        <td >${user.address }</td>
					        <td >${user.zipcode }</td>
					        <td >${user.phone }</td>
					        <td >${user.email }</td>
					        <td >${user.admin }</td>
				        </tr>
					</c:forEach>
				</c:if>
					</table>
			</div>
     	</div>
   	</div>

    
        <div class="container">
          <div class="row">
          <div  class="panel panel-default">
            <div class="col-sm-4 col-sm-offset-4">
            <form action="updateUser" method ="POST">
                <h2 class="text-center">User Detail Update</h2>
                <br/>
                <div class="form-group">
                    <input type="text" class="form-control" name="id" placeholder="User Id">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="firstName" placeholder="First Name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="lastName" placeholder="Last Name">
                </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="email" placeholder="Email">
                </div>
                 <div class="form-group">
                    <input type="text" class="form-control" name="admin" placeholder="Admin">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="address" placeholder="Address">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="zipcode" placeholder="ZipCode">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="phone" placeholder="Phone">
                </div>
              
                <br/>
                <div class="text-center">
                    <button type="submit" class="btn btn-default" id="update" value="submit" >Update</button>
                </div>
            </form>
        </div>
    </div>
</div>
</div>




<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
</body>
</html>