<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/add.css" type="text/css">
<style type="text/css">
. control-label col-sm-2{
width: 20.666667%;
}
</style>
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
												 <a href="StoreController"><button type="button" class="btn btn-primary">HOME</button></a>
 												<a href="StoreController?action=logout"><button type="button" class="btn btn-primary">LOGOUT</button></a>
  											
									</div>


							</div>
			</div>	
			
			
			<div class="head3">			
			
			
			<div class="cd1">	
			
			<br>
			<h1><b>QUICK ACCESS</b></h1>
			<br>
		<div ><a href="StoreController?action=addNewStoreId"style="color:white;">Add New Store</a><br></div><br><br>
		<div><a href="StoreController?action=addNewProduct"style="color:white;">Add New Product</a><br></div><br><br>
		<div><a href="StoreController?action=updateProductDetail"style="color:white;">Update Product Detail</a><br></div><br><br>
		<div><a href="StoreController?action=showProduct"style="color:white;">View Product</a><br></div><br><br>
		<div><a href="StoreController?action=showThProduct"style="color:white;">Show Th Product</a><br></div><br><br>
		<div><a href="StoreController?action=poGenerate"style="color:white;">Purchase order generate</a><br></div><br><br>
			
			
			</div>
		
										<div class="g1">	
											
											</div>
									<div class="cd2" >

									
									
		<b>															
		<div style="color:brown;">															
		<%
		
		if(session.getAttribute("msg") != null){
			out.println(session.getAttribute("msg").toString());
			session.removeAttribute("msg");
		}
		DCStore dd = (DCStore)request.getAttribute("StoreDetail");
		if(dd != null){
	%>															
	</div></b>
		
	
																	
																	
																							<h1 align="center" style="color: #2222B5"><b>Store page</b></h1>
								
																
																	
						
														<div class="form-group">		 
																  <label class="control-label col-sm-2" for="Store ID"style="width: 20.666667%;">Store Id </label>
																	  <div class="col-sm-10">
																	 <input type="text" class="form-control" id="Store_ID" value="<%= dd.getSid() %>" readonly>
																	 </div>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="DC_ID"style="width: 20.666667%;">DC ID </label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="DC_ID" value="<%=dd.getDcId() %>">
														</div>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Store Phone No"style="width: 20.666667%;">Store Phone NO</label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="SPhone No" value="  <%= dd.getSphone() %>"readonly>
														</div>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Store Manager" style="width: 20.666667%;" >Store Manager</label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="Smanager" value=" <%=dd.getsManager()%>" readonly>
														</div>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Address1" style="width: 20.666667%;">DC Address</label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="Address1" value="<%= dd.getAddress1()+" "+dd.getAddress2()+"\n "+dd.getCity()+"  "+dd.getPin() %>"readonly>
											
														</div>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Address2" style="width: 20.666667%;">DC State</label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="Enter Address2" value=" <%= dd.getState() %>">
														</div>
														</div>
														<div class="form-group">
																	 <label class="control-label col-sm-2" for="Pin Code" style="width: 20.666667%;">DC Landmark </label>
																	 <div class="col-sm-10">
																	 <input type="text" class="form-control" id="Pin Code" value="<%=dd.getLandmart() %>">
														</div>
														</div>
														
																		  
																		  								 
																		  
									</div>
				
				<%} %>
				
				
				<div class="g2">
				</div>
				
		
		</div>
			
			
			<div class="foot">
		<p>@copyright group1</p>
		</div>
		</div>
</body>
</html>
