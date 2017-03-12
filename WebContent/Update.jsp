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
<%ArrayList<DCStore> dcstore = (ArrayList<DCStore>)request.getAttribute("dcDetail");
		if(dcstore.size() > 0){	%>
		<form action="DCController" method="post">
		<br>Select a Store Name :
		<select name="sid" id="sel">
		<%for(DCStore dcs:dcstore){ %>
			<option value=<%= dcs.getSid()%>><%=dcs.getSid()+"("+dcs.getsManager()+")" %></option>
		<%} %>	
		<%}%>
		</select>
		<input type ="submit" value = "submit">
		<input type ="hidden" name = "action" value = "UpdateStores">
		</form>


</body>
</html>