<%@ page import="coding.mentor.entity.Book"%>
<%@ page import="coding.mentor.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
		<%
		if (request.getParameter("categoryId") != null){
			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			
 			BookService service = new BookService();
 			pageContext.setAttribute("booklist", service.getBooksByCategoryId(categoryId));
 		}
	
 		
 		if (request.getParameter("bookName") != null) {
 			String bookName = request.getParameter("bookName");
 			
 			BookService service = new BookService();
 			pageContext.setAttribute("booklist", service.getBooksByName(bookName));
 		}
 		
 		%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
	Welcome to Book List
	<hr>
	<ul>
		<c:forEach var="book" items="${booklist}">
			<li>${book.name} - ${book.id} - ${book.categoryId}</li>
		</c:forEach>
	</ul>
</body>
</html>