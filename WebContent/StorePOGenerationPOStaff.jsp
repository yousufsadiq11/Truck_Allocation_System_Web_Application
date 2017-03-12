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



				<h2 align="center" style="color: #2222B5;">
					<b>Select DC For PO Generation</b>
				</h2>
				<br>
				
				<br> <br>
				<%
					if (request.getAttribute("msg") != null) {
						out.println(request.getAttribute("msg").toString());
					}
				ArrayList<DCDetail> dc=(ArrayList<DCDetail>)request.getAttribute("DCs"); 
					if (dc.size() > 0) {
				%>
				<form name="vform" action="POStaffController" method="get"
					class="form-horizontal" role="form" onsubmit="return validate();">
					<div class="form-group">
						<label class="control-label col-sm-2" for="DC_ID"
							style="width: 26.666667%;">Select a DC ID</label>
						<div class="col-sm-10">
							<select name="dcid" id="sel" class="form-control">
								<%
									for (DCDetail pobj : dc) {
								%>
								<option value=<%=pobj.getDcId()%>><%=pobj.getDcId()%></option>
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
					<input type="hidden" name="action" value="DCID">
				</form>
				<%
		}else{
	%>
				Sorry No product in DC
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