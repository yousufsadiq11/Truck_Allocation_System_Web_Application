<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList,bean.DCStore" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" href="img/3.jpg" type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/view.css" type="text/css">
<script src="jquery.min.js"></script>
<script src="bootstrap.min.js"></script>
</head>
<body>

<div class="wrapper">

		<div class="head1">
		   					
		
							<div class ="hd1">
							
												<a href="first.html" >
												<img src="img/3.jpg" class="imagel" alt="Demo" style="width:183px; height:103px;">
												</a>
							
							</div>
						
		
							<div class ="hd2">
												<h1 style="color: white;font-family:cursive;font-size:35px;"><b>TECHKART</b></h1>
							
							
							
						
									<div class="btn-group" >
												  <a href="POStaffController" ><button type="button" class="btn btn-primary">HOME</button></a>
 												 <a href="POStaffController?action=logout" ><button type="button" class="btn btn-primary">LOGOUT</button></a>
  											
									</div>
									


							</div>
			</div>	
			
			
			<div class="head3">	
			
			<div class="f1">
			
			
		
					</div>
					<div class="f2">
					
					
				
					
				<h2>All Stores of Unit Head</h2>	
				
	<% ArrayList<DCStore> dc=(ArrayList<DCStore>)request.getAttribute("Stores"); %>
<% if (dc.size()>0){%>	
					
					
					
						<table class="table table-striped" align="center">
    <thead style="font-family:cursive;background-color:#00CC00;color:white">    
    <tr>
			    <th>Store ID</th>
				<th>DC ID</th>
				<th>Store Manager</th>
				<th>Store Phone</th>
				<th>Address1</th>
				<th>Address2</th>
				<th>Pin</th>
				<th>City</th>
				<th>State</th>
				<th>Landmark</th>
			</tr>
    </thead>
    <tbody style="font-family:monospace">
    <% for(DCStore dcd:dc){ %>
			<tr>
			    <td><%=dcd.getSid() %></td>
			    <td><%=dcd.getDcId() %></td>
			    <td><%=dcd.getsManager() %></td>
			    <td><%=dcd.getSphone() %></td>
			    <td><%=dcd.getAddress1() %></td>
			    <td><%=dcd.getAddress2() %></td>
			    <td><%=dcd.getPin() %></td>
			    <td><%=dcd.getCity() %></td>
			    <td><%=dcd.getState() %></td>
			    <td><%=dcd.getLandmart() %></td>
			</tr>
           <%} %>
      
    </tbody>
  </table>
<%}else{%>
   		Sorry No Store is available
   		<%	}
   		 %>
			
			
					
					</div>
		
			<div class="f3">
			
			
		
					</div>
			</div>	
			<div class="foot">
		<p>@copyright group1</p>
		</div>
		
	</div>	

</body>
</html>