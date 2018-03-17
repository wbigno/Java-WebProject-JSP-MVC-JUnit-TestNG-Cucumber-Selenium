 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <title>Admin Item List</title>
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
      rel="stylesheet">
</head>
<body>

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
            <a class="navbar-brand" >Restaurant Delivery</a>
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

       <div class="container">
          <div class="row">
            <div class="col-xs-5 col-xs-offset-2 col-sm-6  col-md-8 col-md-offset-2"> 
				<c:if test="${empty itemlist}">
       				<h2 class="text-center" style="strong"><font color="red">No Items found</font></h2>
    			</c:if>
   					<h2>Item Details</h2>
						<table class="table table-striped" >
							<tr>
								<th>Item ID</th>
								<th>Item Name</th>
								<th>Item Description</th>
								<th>Item Price</th>
								<th>Item Active</th>
								<th>Item Category</th>
							</tr>
		 		<c:if test="${!empty itemlist}">
        			<c:forEach items="${itemlist}" var="items">
				        <tr>
					        <td align="center">${items.id }</td>
					        <td align="center">${items.itemName }</td>
					        <td align="center">${items.description }</td>
					        <td align="center">${items.price }</td>
					        <td align="center">${items.active }</td>
					        <td align="center">${items.category }</td>
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
            <form action="disableItem" method ="POST">
                <h2 class="text-center">Disable Item</h2>
                <br/>
                <div class="form-group">
                    <input type="text" class="form-control" name="id" placeholder="Item Id">
                </div>
                <br/>
                <div class="text-center">
                    <button type="submit" class="btn btn-default" id="disableItem" value="submit" >Disable Item</button>
                </div>
            </form>
        </div>
            <div class="col-md-6 col-sm-6 col-xs-6">
            <form action="enableItem" method ="POST">
                <h2 class="text-center">Enable Item</h2>
                <br/>
                <div class="form-group">
                    <input type="text" class="form-control" name="id" placeholder="Item Id">
                </div>
                <br/>
                <div class="text-center">
                    <button type="submit" class="btn btn-default" id="enableItem" value="submit" >Enable Item</button>
                </div>
            </form>
        </div>
    </div>
</div>


<div class="jumbotron">
        <div class="container">
          <div class="row">
            <div class="col-md-6 col-sm-6">
            <form action="updateItem" method ="POST">
                <h2 class="text-center">Item Detail Update</h2>
                <br/>
                <div class="form-group">
                    <input type="text" class="form-control" name="id" placeholder="Item Id">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="itemName" placeholder="Item Name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" placeholder="Description">
                </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="price" placeholder="Price">
                </div>
                 <div class="form-group">
                    <input type="text" class="form-control" name="category" placeholder="Category">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="images" placeholder="Image URL" "">
                </div>
                <br/>
                <div class="text-center">
                    <button type="submit" class="btn btn-default" id="update" value="submit" >Update</button>
                </div>
            </form>
        </div>
  

            <div class="col-md-6 col-sm-6">
            <form action="addItem" method ="POST">
                <h2 class="text-center">Add Item</h2>
                <br/>
                <div class="form-group">
                    <input type="text" class="form-control" name="itemName" placeholder="Item Name">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="description" placeholder="Description">
                </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="price" placeholder="Price">
                </div>
                 <div class="form-group">
                    <input type="text" class="form-control" name="category" placeholder="Category">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="images" placeholder="Image URL" "">
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

  </div> <!-- /container -->
  
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>

</body>
</html>