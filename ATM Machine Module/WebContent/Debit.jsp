<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Debit Transaction</title>
</head>
<body background="shapes.jpg">
	<form action="DebitServlet" method="post">
		<fieldset>
			<legend>
				<font size="6"><b>Withdraw Section</b></font>
			</legend>
			<h2>Enter The Amount You Want To Withdraw</h2>
			<input type="number" placeholder="Amount" name="amount" min="1"
				max="20000" style="font-size: 16pt" autofocus required><br>
			<br> <input type="submit" value="WITHDRAW"
				style="font-size: 16pt; font-weight: bold">
		</fieldset>
	</form>

</body>
</html>