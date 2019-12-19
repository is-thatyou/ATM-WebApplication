<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.atm.entity.Account"%>	
<%@page import="com.atm.entity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BalanceEnquiry</title>
</head>
<body background="shapes.jpg">
<h1><center>Available Balance Details</center></h1>
	<%
		String Balance = session.getAttribute("BALANCE").toString();
	%>

	<%
		ArrayList<Customer> userDetails = new ArrayList<Customer>();
		userDetails = (ArrayList<Customer>) request.getSession().getAttribute("DETAILS");
	%>
	<center>
		<table border="3">
			<tr>
				<th>Account No</th>
				<th>Customer Name</th>
				<th>Available Balance</th>
			</tr>
			<%
				if (userDetails != null) {
					Iterator<Customer> iterator = userDetails.iterator();
					while (iterator.hasNext()) {
						Customer details = iterator.next();
			%>
			<tr>
				<td align="center"><%=details.getAccount_No()%></td>
				<td align="center"><%=details.getName()%></td>
				<td align="center" style="font-weight: bold" ><%=Balance%></td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</center>
</body>
</html>