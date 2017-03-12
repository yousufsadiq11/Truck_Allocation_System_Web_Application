<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%DCStore dcs = (DCStore)request.getAttribute("StoreDetails"); %>
<form action="DCController" method="post">
Storeid :  <input type="text" name="sid" value="<%= dcs.getSid()%>" readonly><br>
DcId:  <input type="text" name="Dcid" value="<%= dcs.getDcId()%>" readonly><br>
		Enter Store Manager Name : <input type="text" name="mName" value="<%= dcs.getsManager()%>"><br>
		Enter Store Phone No : <input type="text" name="sPhone"  value="<%=dcs.getSphone() %>" ><br>
		Enter Address1 : <input type="text" name="add1"  value="<%=dcs.getAddress1() %>"><br>
		Enter Address2 : <input type="text" name="add2"value="<%=dcs.getAddress2() %>"><br>
		Enter Pin Code : <input type="text" name="pin"value="<%= dcs.getPin()%>"><br>
		Enter City : <input type="text" name="city"value="<%=dcs.getCity() %>"><br>
		Enter State : <input type="text" name="state"value="<%=dcs.getState() %>"><br>
		Enter Landmark : <input type="text" name="landmark"value="<%=dcs.getLandmart() %>"><br>
		<br><input type="hidden" name="action" value="UpdateDCStorePage">
		<input type="submit">
	</form>

</body>
</html>