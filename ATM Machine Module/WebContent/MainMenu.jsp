<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Main Menu</title>
</head>
<body background="shapes.jpg">
	<form action="MenuServlet" method="post">
		<input type="submit" Value="Deposit" name="option" /> <br> <input
			type="submit" Value="Withdraw" name="option" /><br> <input
			type="submit" Value="BalanceEnquiry" name="option" /> <br>
	</form>

</body>
</html>