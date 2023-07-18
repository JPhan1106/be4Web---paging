<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
<style>
* {
	box-sizing: border-box;
}

/* Create two equal columns that floats next to each other */
.sub-body {
	float: left;
	width: 30%;
	padding: 10px;
	height: 100px; /* Should be removed. Only for demonstration */
}

/* Clear floats after the columns */
.body:after {
	content: "";
	display: table;
	clear: both;
}
</style>

</head>

<body>
	<div class="header">
		<form action="search">
			<input type="text" name="bookName" value="${param.bookName}">
			<input type="submit" value="Search">
		</form>
	</div>

	<hr>

	<div class="body">
		<div class="sub-body">
			<ul>
				<c:forEach var="category" items="${categoryList}">
					<a href="home?categoryId=${category.id}">
						<li>${category.name}</li>
					</a>
				</c:forEach>
			</ul>
		</div>
		<div class="sub-body">
			<c:if test="${empty bookList}">
				 No Book
			</c:if>
			 <c:if test="${not empty bookList}">
					<ul>
						<c:forEach var="book" items="${bookList}">
							<a href="search?bookName=${'%'}${book.name}${'%'}">
								<li>${book.name}</li>
							</a>
						</c:forEach>
					</ul>
			</c:if>
		</div>
	</div>

	<hr>
