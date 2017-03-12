<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHKART</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/add.css" type="text/css">

<script type="text/javascript" src="js/validatestore.js"></script>
<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>
</head>
<body>

	<div class="wrapper">

		<div class="head1">


			<div class="hd1">

				<a href="aaa"> <img src="img/3.jpg" class="imagel" alt="Demo"
					style="width: 183px; height: 103px;">
				</a>

			</div>


			<div class="hd2">
				<h1 style="color: white; font-family: cursive; font-size: 35px;">
					<b>TECHKART</b>
				</h1>




				<div class="btn-group">
					<a href="StoreController"><button type="button"
							class="btn btn-primary">HOME</button></a> <a
						href="StoreController?action=logout"><button type="button"
							class="btn btn-primary">LOGOUT</button></a>

				</div>


			</div>
		</div>


		<div class="head3">


			<div class="cd1">

				<br>
				<h1>
					<b>QUICK ACCESS</b>
				</h1>
				<br>
				<div>
					<a href="StoreController?action=addNewStoreId"
						style="color: white;">Add New Store</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="StoreController?action=addNewProduct"
						style="color: white;">Add New Product</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="StoreController?action=updateProductDetail"
						style="color: white;">Update Product Detail</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="StoreController?action=showProduct" style="color: white;">View
						Product</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="StoreController?action=showThProduct"
						style="color: white;">Show Th Product</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="StoreController?action=poGenerate" style="color: white;">Purchase
						order generate</a><br>
				</div>
				<br>
				<br>


			</div>

			<div class="g1"></div>
			<div class="cd2">



				<h2 align="center" style="color: #2222B5;">
					<b>Update Product</b>
				</h2>
				<br>
				 <br>
				 <b>
				<div style="color:green;">
				<%
					if (session.getAttribute("msg") != null) {
						out.println(session.getAttribute("msg").toString());
						session.removeAttribute("msg");
					}
					ArrayList<Product> obj = (ArrayList<Product>) request
							.getAttribute("products");
					if (obj.size() > 0) {
				%>
				</div></b>




				<form name="vform" action="StoreController" method="get"
					class="form-horizontal" role="form" onsubmit="return validate();">


					<div class="form-group">
						<label class="control-label col-sm-2" for="DC_ID"
							style="width: 26.666667%;">Select a Product Id</label>
						<div class="col-sm-10">
							<select name="pid" id="sel" class="form-control" id="sel">
								<%
									for (Product pobj : obj) {
								%>
								<option value=<%=pobj.getPid()%>><%=pobj.getPid()%></option>
								<%
									}
								%>
							</select>
						</div>
					</div>










					<div class="form-group">
						<label class="control-label col-sm-2" for="DC_ID"
							style="width: 23.666667%;">Available Quantity</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="quantity" value=""
								placeholder="Enter Available Quantity"><span id="q"></span>
						</div>
					</div>
					<div class="form-group">


						<label class="control-label col-sm-2" for="DC Phone No"
							style="width: 17.666667%;">Th Value</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="th" value=""
								placeholder="Enter Th Value"><span id="th"></span>
						</div>
					</div>




					<br> <br> <br> <br> <br>
					<div class="form-inline">




						<button type="submit" class="btn btn-success"
							onclick="return validate();">Submit</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>
					<input type="hidden" name="action" value="updateProductQuantity">




				</form>
				<%}else{ %>
				Sorry No product in DC
				<%} %>

				<br> <br>






			</div>




			<div class="g2"></div>


		</div>


		<div class="foot">
			<p>@copyright group1</p>
		</div>

	</div>

</body>
</html>