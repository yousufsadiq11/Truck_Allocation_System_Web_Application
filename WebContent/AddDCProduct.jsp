<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>DC Page</h1>
	<h2>Add product to Dc</h2>
		<form action="DCController">
			<input type="hidden" name="action" value="addProduct">
			Product ID & Name 
			<select name="product">
				
			</select>
		</form>
	<a href="DCController">Home Page</a>
</body>
</html>