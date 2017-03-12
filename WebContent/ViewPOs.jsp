<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.ArrayList,bean.PurchaseOrder,services.UHService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/add.css" type="text/css">
<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>
</head>
<body>

<div class="wrapper">

		<div class="head1">
		   					
		
							<div class ="hd1">
							
												<a href="aaa" >
												<img src="img/3.jpg" class="imagel" alt="Demo" style="width:183px; height:103px;">
												</a>
							
							</div>
						
		
							<div class ="hd2">
												<h1 style="color: white;font-family:cursive;font-size:35px;"><b>TECHKART</b></h1>
							
							
							
						
									<div class="btn-group" >
												 <a href="aaa"><button type="button" class="btn btn-primary">HOME</button></a>
 												 <a href="aaa?action=logout"><button type="button" class="btn btn-primary">LOGOUT</button></a>
  											
									</div>


							</div>
			</div>	
			
			
			<div class="head3">			
			
			
			<div class="cd1">	
			
			<br>
			<h1><b>QUICK ACCESS</b></h1>
			<br></br>
						<br>
		<div><a href="aaa?action=viewDCs" style="color:white;">View all DCs </a><br></div><br><br><br>
		<div><a href="aaa?action=viewStores"style="color:white;">View all stores</a><br></div><br><br><br>
		<div><a href="aaa?action=viewProducts"style="color:white;">View all products</a><br></div><br><br><br>
		<div><a href="aaa?action=viewVendors"style="color:white;">View all vendors</a><br></div><br><br><br>
		<div><a href="AddVendors.jsp"style="color:white;">Add new vendor</a><br></div><br><br><br>
		<div><a href="AddProducts.jsp"style="color:white;">Add new product</a><br></div><br><br><br>
		<div><a href="aaa?action=viewPOs"style="color:white;"> View all POs</a><br></div><br><br><br>
			
			
			
			
			</div>
		
										<div class="g1">	
											
											</div>
									<div class="cd2" >

									
									
				<h2 align="center" style="color: #2222B5;"><b>Unit Head POs Page</b></h2>
														
<br><br>
<h3><a href="aaa?action=ViewNewPOS">Newly Generated POs</a></h3><br>
<h3><a href="aaa?action=approvedPOS">Approved POS</a></h3><br>
<h3><a href="ClosedPOs.jsp">Closed POs</a></h3><br>
<h3><a href="PastPOs.jsp">Past POs</a></h3>			
																		  
																		  								 
																		  
									</div>
				
				
				
				
				<div class="g2">
				</div>
				
		
		</div>
			
			
			<div class="foot">
		<p>@copyright group1</p>
		</div>
		
	</div>	


</body>
</html>