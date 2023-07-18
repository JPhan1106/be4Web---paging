<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<div style="display: flex; padding: 20px;">
		<div style="width: 10%;"></div>
		<div style="width: 70%;">
			<c:if test="${not empty cart}">
				<h4>Book(s) in Cart:</h4>
				<hr>
				<c:forEach var="book" items="${cart}" varStatus="status">
					${status.count}: ${book.value.name} - $${book.value.price} ----- <a
						href="cart?command=REMOVE&bookId=${book.key}"> Remove</a>
					<br>
					<c:set var="totalPrice" value="${totalPrice + book.value.price}" />
				</c:forEach>
				<br>
				<br>
				<br>
    				Total Price: $${totalPrice}
    			<br>
				<br>
				<input type="button" value="Check Out" onClick="window.location.href='cart?command=SUBMIT_CART'" />
			</c:if>

			<c:if test="${empty cart}">
				<h4>Empty Cart</h4>
			</c:if>
		</div>
	</div>
</body>
</html>