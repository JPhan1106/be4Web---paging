<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order details</title>
</head>
<body>
    <h1>${checkoutMessage}</h1>

    <h2>Your order details:</h2>
    <c:forEach var="book" items="${booksInOrderDetail}">
        <p>Book Name: ${book.name} --- Price: ${book.price}</p>
    </c:forEach>
    	<h3> Total: $${total} </h3>
</body>