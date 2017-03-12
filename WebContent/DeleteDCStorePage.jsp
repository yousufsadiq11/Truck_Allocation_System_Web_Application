
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
					<a href="DCController"><button type="button"
							class="btn btn-primary">HOME</button></a> <a
						href="DCController?action=logout"><button type="button"
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
					<a href="DCController?action=addNewDCID" style="color: white;">Create
						New DC </a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=addNewStoreId" style="color: white;">Add
						New Store</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=addNewProduct" style="color: white;">Add
						New Product</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=updateProductDetail"
						style="color: white;">Update Product Detail</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=viewStore" style="color: white;">View
						DC's Store</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=showProduct" style="color: white;">View
						Product</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=showThProduct" style="color: white;">Show
						Th Product</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=poGenerate" style="color: white;">Guenerate
						Purchase order </a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=storeApprovedPOs"
						style="color: white;">Store Approved POs</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=storeGeneratedPOs"
						style="color: white;">Store Generated POs</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=DeleteDCStorePage"
						style="color: white;">Delete Store</a><br>
				</div>
				<br>
				<br>
				<div>
					<a href="DCController?action=Update" style="color: white;">Update
						DC Store</a><br>
				</div>
				<br>
				<br>




			</div>


			<div class="g1"></div>
			<div class="cd2">



				<h2 align="center" style="color: #2222B5;">
					<b>Delete Store Page</b>
				</h2>
				<br>
				
				<br> <br>
				<%
				 if(request.getAttribute("msg") != null){ 
						out.println(request.getAttribute("msg").toString());
					}
					ArrayList<DCStore> dcstore = (ArrayList<DCStore>)request.getAttribute("dcDetail");
					if(dcstore.size() > 0){	
				%>
				<form name="vform" action="DCController" method="post"
					class="form-horizontal" role="form" >
					<input type ="hidden" name = "action" value = "DeletedStores">
					<div class="form-group">
						<label class="control-label col-sm-2" for="DC_ID"
							style="width: 26.666667%;">Select a DC ID</label>
						<div class="col-sm-10">
							<select name="sid" id="sel" class="form-control">
								<%
								for(DCStore dcs:dcstore){
								%>
								<option value=<%= dcs.getSid()%>><%=dcs.getSid()+"("+dcs.getsManager()+")" %></option>
								<%
									}
								%>
							</select>
						</div>
					</div>
					<br> <br> <br>
					<div class="form-inline">
						<button type="submit" class="btn btn-success"
							onsubmit="return validate();">Submit</button>
						<button type="reset" class="btn btn-danger">Reset</button>
					</div>
					
				</form>
				<%
		}else{
	%>
				Sorry Store product in DC
				<%	}
	%>
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