
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList,bean.*" %>
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
												  <a href="DCController" ><button type="button" class="btn btn-primary">HOME</button></a>
 												 <a href="DCController?action=logout" ><button type="button" class="btn btn-primary">LOGOUT</button></a>
  											
									</div>
									<div class="btn-group">
   												<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    															Go To <span class="caret"></span></button>
   																 <ul class="dropdown-menu" role="menu">
    																		  <li><a href="add.html">dc page</a></li>
    																		  <li><a href="addstore.html">store page</a></li>
    																		  <li><a href="DCProductViewPage.html"">DC Product ViewPage</a></li>
    																		   <li><a href="dcpage.html">DC page2</a></li>
    																		  <li><a href="DCStoreViewPage.html">DC Store View page</a></li>
   																 </ul>
   																  
   															
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
}
 %>
					<% ArrayList<PurchaseOrder> pobj = (ArrayList<PurchaseOrder>)session.getAttribute("SPOs"); 
		if(pobj.size() > 0){%>
		
			<table class="table table-striped" align="center">
    <thead style="font-family:cursive;background-color:#00CC00;color:white"> 
     <caption><h1>Generated PO Details</h1></caption>
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
			<tbody style="font-family:monospace">
			 <% for(PurchaseOrder po3:pobj){
            	if (po3.getStatus().equals("s")){%>
			<tr>
			    <td><%=po3.getPoId() %></td>
			    <td><%=po3.getPoDate() %></td>
			    <td><%=po3.getDcId() %></td>
			    <td><%=po3.getvId() %></td>
			    <td><%=po3.getEdate() %></td>
			    <td><%=po3.getDts() %></td>
			    <td><%=po3.getShipId() %></td>
			    <td><%=po3.getStatus() %></td>
			    <td><a href="DCController?action=approvePO&poid=<%=po3.getPoId() %>">Approve PO</a></td>
			</tr>
           <%} 
           }%>
		</table>
	<%
		}else{%>
		Sorry No PO is available
	<%}%>
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
	