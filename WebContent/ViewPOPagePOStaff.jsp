<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList,bean.PurchaseOrder" %>
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
					
					
				
				 
			<%		
if(session.getAttribute("msg") != null){
	out.println(session.getAttribute("msg").toString());
	session.removeAttribute("msg");
}%>
				<% ArrayList<PurchaseOrder> poa2=(ArrayList<PurchaseOrder>)session.getAttribute("POs"); %>
					<% if (poa2.size()>0){%>
					
					
					
						<table class="table table-striped" align="center">
						<caption><h1>Newly generated PO Details</h1></caption>
    <thead style="font-family:cursive;background-color:#00CC00;color:white">    
   
			<tr>
			    <th>PO ID</th>
				<th>PO Date</th>
				<th>DC Id</th>
				<th>Vendor Id</th>
				<th>Expected Date</th>
				<th>DTS</th>
				<th>Ship Id</th>
				<th>Status</th>
			</tr>
    </thead>
    <tbody style="font-family:monospace">
    <% for(PurchaseOrder po3:poa2){%>	
			<tr>
			    <td><%=po3.getPoId() %></td>
			    <td><%=po3.getPoDate() %></td>
			    <td><%=po3.getDcId() %></td>
			    <td><%=po3.getvId() %></td>
			    <td><%=po3.getEdate() %></td>
			    <td><%=po3.getDts() %></td>
			    <td><%=po3.getShipId() %></td>
			    <td><%=po3.getStatus() %></td>
			</tr>
           <%
           }%>
		</table>
	<%
		}else{%>
		Sorry No PO is available
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