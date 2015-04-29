<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signup Page</title>
</head>
<body>

<form action="Check" method="post">
		<fieldset style="width: 300px">
			<legend> Signup </legend>
			<table>
				<tr>
					<td>User ID</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Sign Up" /></td>
					<td><input type="reset" value="Reset" /></td>
					<a href="index.jsp">Login</a>
					
				</tr>
			</table>
		</fieldset>
	</form>


</body>
</html>