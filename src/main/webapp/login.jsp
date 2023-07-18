<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<h1>Please enter your details</h1>
	<!-- Login Form begins -->
	<form action="login" method="post">
		Username: <input type="text" name="username" value="${param.username}" />
		<br> Password: <input type="password" name="password"
			value="${param.password}" /> <br> <input type="submit"
			value="Login" />
	</form>

	<c:if test="${not empty errorMessage}">
		<p style="color: red; font-weight: bold;">${errorMessage}</p>
	</c:if>
	<!-- Login Form begins -->
</body>
</html>