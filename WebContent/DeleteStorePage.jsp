<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>In Stores Center</h1>
	<h2>Delete   Product in stores</h2>
	<div>
	<% if(request.getAttribute("msg") != null){ 
			out.println(request.getAttribute("msg").toString());
		}%>
	</div>
	<%ArrayList<Product> dcstore = (ArrayList<Product>)request.getAttribute("StoreDeleteDetail");
		if(dcstore.size() > 0){	%>
		<form action="StoreController" method="post">
		<br>Select a Store Name :
		<select name="sid" id="sel">
		<%for(Product dcs:dcstore){ %>
			<option value=<%= dcs.getPid()%>><%=dcs.getPname()+"("+ dcs.getPid()+")" %></option>
		<%} %>	
		<%}%>
		</select>
		<input type ="submit" value = "submit">
		<input type ="hidden" name = "action" value = "DeleteTheStores">
		</form>

</body>
</html>