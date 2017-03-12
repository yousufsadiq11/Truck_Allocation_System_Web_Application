<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="bean.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TECHKART</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/add.css" type="text/css">

<meta name="viewport" content="width=device-width, initial-scale=1">




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
					<a href="POStaffController"><button type="button"
							class="btn btn-primary">HOME</button></a> <a
						href="POStaffController?action=logout"><button type="button"
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
					<a href="POStaffController?action=generatePO" style="color: white;">Generate New PO </a><br>
				</div>
				<br> <br>
				<div>
					<a href="POStaffController?action=viewPOs" style="color: white;">View POs</a><br>
				</div>
				<br> <br>
				<div>
				<a href="POStaffController?action=viewDC" style="color: white;">View DC</a><br>
				</div>
				<br> <br>
				<div>
					<a href="POStaffController?action=viewStore"
						style="color: white;">View Store</a><br>
				</div>
			</div>

			<div class="g1"></div>
			<div class="cd2">















				<%
	
		if(session.getAttribute("poStaff") != null){		
			Login dd = (Login)session.getAttribute("poStaff");
		
	%>
				<h1 align="center" style="color: #2222B5">
					<b>Purchace Order Staff</b>
				</h1>

				<%	
										if(session.getAttribute("msg") != null){
											out.println(session.getAttribute("msg").toString());
											session.removeAttribute("msg");
										} %>

				<br>
				<br>
				<div class="form-group">
					<label class="control-label col-sm-2" for="Pin Code">DC
						Staff Id </label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="Pin Code"
							value="<%=dd.getUserId() %>" readonly>
					</div>
				</div>




			</div>

			<%}else{
				response.sendRedirect("home.jsp");
			}
				%>



			<div class="g2"></div>


		</div>


		<div class="foot">
			<p>@copyright group1</p>
		</div>
	</div>
</body>
</html>