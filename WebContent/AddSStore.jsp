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

<meta name="viewport" content="width=device-width, initial-scale=1">


<script type="text/javascript" src="js/validateAddSStore.js"></script>

<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>
</head>
<body>



	<div class="wrapper">

		<div class="head1">


			<div class="hd1">

				<a href="DCController"> <img src="img/3.jpg" class="imagel"
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
					<b>Add New Store</b>
				</h2>
				<br>
				
				<b><div style="color:red;">
				<%
					if (session.getAttribute("error") != null) {
						out.println(session.getAttribute("error").toString());
						session.removeAttribute("error");
					}
				%></div></b>



















				<form name="addSStoreForm" action="StoreController" method="post"
					class="form-horizontal" role="form" onsubmit="return validate();">

					<div class="form-group">
						<label class="control-label col-sm-2" for="DC_ID">Store
							ID:</label>
						<div class="col-sm-10">


							<input type="text" class="form-control" name="sId"
								value="<%=request.getAttribute("sid")%>" readonly><span
								id="sId"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="DC Phone No">Phone
							No :</label>
						<div class="col-sm-10">

							<input type="text" class="form-control" name="sPhone"
								placeholder="Enter Store Phone No "><span id="sPhone"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Address1">
							Manager Name:</label>
						<div class="col-sm-10">

							<input type="text" class="form-control" name="mName"
								placeholder="Enter Store Manager Name "><span id="mName"></span>
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-sm-2" for="Address2">
							Address1 :</label>
						<div class="col-sm-10">

							<input type="text" class="form-control" name="add1"
								placeholder="Enter Address1"><span id="add1"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Address2">
							Address2 :</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="add2"
								placeholder="Enter Address2"><span id="add2"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Pin Code">Pin:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="pin"
								placeholder="Enter Pin Code"><span id="pin"></span>
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-sm-2" for="City">City :</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="city"
								placeholder="Enter City"><span id="city"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for=" State">State:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="state"
								placeholder="Enter State"><span id="state"></span>
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-sm-2" for="Landmark">Landmark
							:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="landmark"
								placeholder="Enter Landmark"><span id="landmark"></span>
						</div>
					</div>



					<div class="form-group">
						<label class="control-label col-sm-2" for="Store Staff Id ">Id
							:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="id"
								value="<%=request.getAttribute("id")%>" readonly><span
								id="id"></span>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Store  Staff Password">Password
							:</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="pass"
								placeholder="Enter Store Staff Password"><span id="pass"></span>
						</div>
					</div>

					<br> <br> <br>

					<div class="form-inline">

						<button type="submit" class="btn btn-success"
							onclick="return validate();">Submit</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>
					<input type="hidden" name="action" value="addStore">

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