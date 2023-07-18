<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>be4 Web</title>
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

.sub-header {
	display: inline-block;
	width: 15%;
	padding: 10px;
}

#search {
	padding-top: 0px;
	padding-bottom: 20px;
	width: 40%;
}

.footer {
	font-weight: bold;
}
</style>

</head>

<body>

	<div class="header">
		<!--Search Form begins  -->
		<div class="sub-header" id="search">
			<form action="home">
				<input type="text" name="bookName" value="${bookName}"> <input
					type="submit" value="Search">
			</form>
		</div>
		<!--Search Form ends  -->

		<!-- Login Link begins -->
		<div class="sub-header link">
			<c:if test="${not empty username}">
			Hello ${username} !!!
		</c:if>
			<c:if test="${empty username}">
				<a href="login.jsp">Login</a>
			</c:if>
		</div>
		<!-- Login Link begins -->

		<!-- Register Link begins -->
		<div class="sub-header link">
			<a href="register.jsp">Registration</a>

		</div>
		<!-- Register Link begins -->
		<!-- Cart begins -->
		<div class="sub-header">
			<a href="cart?command=VIEW_CART">Cart(${empty sessionScope.cart? 0 : sessionScope.cart.size()})</a>
		</div>
		<!-- Cart ends -->
	</div>

	<hr>

	<!-- Category List and Book List starts -->
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
			<c:if test="${empty bookList and empty bookListBySearch}">
			No Book
		</c:if>
			<c:if test="${not empty bookList}">
				<ul>
					<c:forEach var="book" items="${pageBooks}">
						<a href="book?bookId=${book.id}">
							<li>${book.name}</li>
						</a>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${not empty bookListBySearch}">
				<ul>
					<c:forEach var="book" items="${bookListBySearch}">
						<a href="book?bookId=${book.id}">
							<li>${book.name}</li>
						</a>
					</c:forEach>
				</ul>
			</c:if>
		</div>
		<c:if test="${not empty currentPage and totalPages > 1}">
			<div class="pagination">
				<c:if test="${currentPage > 1}">
					<a href="home?page=${currentPage - 1}">&laquo; Previous</a>
				</c:if>
				<c:forEach var="page" begin="1" end="${totalPages}">
					<c:choose>
						<c:when test="${currentPage == page}">
							<span class="current-page">${page}</span>
						</c:when>
						<c:otherwise>
							<a href="home?page=${page}">${page}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${currentPage < totalPages}">
					<a href="home?page=${currentPage + 1}">Next &raquo;</a>
				</c:if>
			</div>
		</c:if>
	</div>


	<!-- Category List and Book List starts -->


	<!-- Footer begins  -->
	<div class="footer">
		<p>This is BE4 Website</p>
	</div>
	<!-- Footer ends  -->