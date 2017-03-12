<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHKART</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/add.css" type="text/css">
<script type="text/javascript" src="js/validateAddVendor.js"></script>
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
					<a href="aaa"><button type="button" class="btn btn-primary">HOME</button></a>
					<a href="aaa?action=logout"><button type="button"
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
					<a href="aaa?action=viewDCs" style="color: white;">View all DCs
					</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="aaa?action=viewStores" style="color: white;">View all
						stores</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="aaa?action=viewProducts" style="color: white;">View
						all products</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="aaa?action=viewVendors" style="color: white;">View all
						vendors</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="aaa?action=addNewVendorId" style="color: white;">Add
						new vendor</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="aaa?action=addNewProductId" style="color: white;">Add
						new product</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="aaa?action=viewPOs" style="color: white;"> View all
						POs</a><br>
				</div>
				<br>
				<br>




			</div>
			<div class="g1"></div>
			<div class="cd2">



				<h2 align="center" style="color: #2222B5;">
					<b>Add New Vendor</b>
				</h2>
				<b><div style="color:red;">
				<%
					if (session.getAttribute("msg") != null) {
						out.println(session.getAttribute("msg").toString());
						session.removeAttribute("msg");
					}
				%></div></b>
				<br>
				<h4 align="center" style="color: #2222B5;">Enter New Vendor
					Detail</h4>

				<form name="addVendorForm" action="aaa" method="post"
					class="form-horizontal" role="form" onsubmit="return validate();">

					<div class="form-group">
						<label class="control-label col-sm-2" for="DC_ID">Vendor
							Id</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="vId"
								value="<%=request.getAttribute("vid")%>" readonly><span
								id="vId"></span>
						</div>
					</div>
					<div class="form-group">








						<label class="control-label col-sm-2" for="DC Phone No">Vendor
							Name</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="vName" value=""
								placeholder="Enter Vendor Name"><span id="vName"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Address1">
							Vendor address </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="vAdd" value=""
								placeholder="Enter Vendor address "><span id="vAdd"></span>
						</div>
					</div>



					<br>

					<div class="form-inline">

						<button type="submit" class="btn btn-success"
							onclick="return validate();">Submit</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>
					<input type="hidden" name="action" value="addVendors">
				</form>
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