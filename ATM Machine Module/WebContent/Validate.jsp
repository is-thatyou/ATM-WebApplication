
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body background="shapes.jpg">
		<center><h1>ABC Bank ATM</h1></center>
		<form action="UserValidation" method="post">
		<fieldset>
		<legend><font size ="6">User Personal Information</font></legend>
			<label for="accountNo"><font size ="5"><b>Account No:</b></font></label><br> 
			<input type="text" id="accountNo" placeholder="Account No" name="accountNo" style="font-size: 14pt" autofocus required> <br> <label
				for="password"><font size ="5"><b> Password:</b></font></label><br> 
				<input type="password" id="password" placeholder="Password" name="pass" style="font-size: 14pt" required><br><br>
				 <input	type="submit" value="Sign-In" style="font-size:16pt; font-weight:bold">
				 </fieldset>
		</form>
	</body>
</html>