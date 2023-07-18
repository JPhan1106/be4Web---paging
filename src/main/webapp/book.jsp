<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Details</title>
</head>
<body>
	Id: ${book.id}
	<br> Name: ${book.name}
	<br> Title: ${book.title}
	<br> Author: ${book.author}
	<br> Stock: ${book.stock}
	<br> Price: $${book.price}
	<br>
	<input type="button" value="Add to Cart"book
		onclick="window.location.href='cart?command=ADD_TO_CART&bookId=${book.id}'" />
</body>
</html>