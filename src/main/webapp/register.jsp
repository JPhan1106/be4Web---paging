<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>New customer? Why not register?</h1>
	<!-- Login Form begins -->
	<form action="register" method="post">
		Username: <input type="text" name="username" value="${param.username}" />
		<br> Email: <input type="email" name="email"
			value="${param.email}" /> <br> Password: <input type="password"
			name="password" value="${param.password}" /> <br> <input
			type="submit" value="Register" />

		<!-- check if there is error  -->
		<c:if test="${not empty errorMessageEmail}">
			<p style="color: red; font-weight: bold;">${errorMessageEmail}</p>
		</c:if>

		<c:if test="${not empty errorMessageEmpty}">
			<p style="color: red; font-weight: bold;">${errorMessageEmpty}</p>
		</c:if>

	</form>

	<!-- Login Form ends-->
</body>
</html>