
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHKART</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/pogenerate.css" type="text/css">


<meta name="viewport" content="width=device-width, initial-scale=1">




<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>

	<div class="wrapper">

		<div class="head1">


			<div class="hd1">

				<a href="first.html"> <img src="img/3.jpg" class="imagel"
					alt="Demo" style="width: 183px; height: 103px;">
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
					<a href="AddSStore.jsp" style="color: white;">Add New Store</a><br>
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



				<h1 align="center" style="color: #2222B5;">
					<b><h2>PO Page</h2></b>
				</h1>
				<br>
				





				<%
		
		if(session.getAttribute("msg") != null){
			out.println(session.getAttribute("msg").toString());
			session.removeAttribute("msg");
		}
		String po = request.getAttribute("pid").toString();
	%>
				<form action="StoreController" method="post">
					<input type="hidden" name="action" value="po">





					<div class="form-group">
						<label class="control-label col-sm-2" for="PO Id">PO Id</label>
						<div class="col-sm-10">

							<input type="text" class="form-control" value=<%= po %>
								name="poid" required>
						</div>
					</div>

					<br>

					<div class="form-group">
						<label class="control-label col-sm-2" for="Expected Date ">Expected
							Date </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="edd" value="dd"
								required><input type="text" name="emm"
								class="form-control" value="mon" required><input
								type="text" class="form-control" name="eyyyy" value="yyyy"
								required><br>
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-2" for="vendor id ">Vendor
							Id </label>
						<div class="col-sm-10">
							<select name="vid" class="form-control">

								<%ArrayList<Vendor> vobj = (ArrayList<Vendor>)request.getAttribute("vendor");
		  ArrayList<Product> pobj = (ArrayList<Product>)request.getAttribute("product");
		  for(Vendor obj: vobj){%>
								<option value="<%=obj.getVid() %>"><%= obj.getVname() %>
									(<%=obj.getVid()%>)
								</option>
								<% }
		%>
							</select>
						</div>
					</div>
					<br> 


					<div class="form-group">
						<label class="control-label col-sm-2" for="DTS ">DTS </label>
						<div class="col-sm-10">
							<select name="vid" class="form-control">
								<option value="1">yes</option>
								<option value="0">No</option>
							</select>
						</div>
					</div>

					<br> <br> <br><br>














					<table class="table table-striped" align="center">
						<thead
							style="font-family: cursive; background-color: #00CC00; color: white">
							<tr>
								<th>Select Product</th>
								<th>Product Name</th>
								<th>Available Quantity</th>
								<th>Th value</th>
								<th>Ordering Quantity</th>
								<th>Unit Price</th>
							</tr>
						</thead>

						<tbody style="font-family: monospace">
							<tr>
								<% int i = 1;
				for(Product temp:pobj){ %>
							
							<tr>
								<td><input type="checkbox" name="check" value="<%=i%>"></td>
								<td><input type="text" name="pid<%=i %>"
									value="<%= temp.getPid() %>" readonly></td>
								<td><input type="text" name="available<%=i %>"
									value="<%= temp.getAvailableQuantity()%>" readonly></td>
								<td><input type="text" name="th<%=i %>"
									value="<%= temp.getTh() %>" readonly></td>
								<td><input type="text" name="quantity<%=i %>" value="0"></td>
								<td><input type="text" name="unit<%=+i %>" value="100"></td>
							</tr>
							<%i++;} %>



						</tbody>
					</table>

					<br> <br> <br>




					<div class="form-inline">

						<button type="submit" class="btn btn-success">Submit</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>

					<input type="hidden" name="nop" value="<%= i%>">

				</form>
				<br> <br>
				<h6 align="center">By clicking on submit button you will be
					redirect to next page</h6>

			</div>




			<div class="g2"></div>


		</div>


		<div class="foot">
			<p>@copyright group1</p>
		</div>

	</div>



</body>
</html>