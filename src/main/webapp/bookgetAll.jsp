<%@page import="com.jsp.dto.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% BookService bookService = new BookService(); %>
	<% List<Book> books = bookService.getAllBooks();%>
	

	<table border="1" style="border-collapse: collapse;">
		<tr style="text-align: center;">
			<th><%="id"%></th>
			<th><%="book name"%></th>
			<th><%="author name"%></th>
		</tr>
		
		<%	for (Book book: books) {	%>
	
		<tr>	
			<td><%= book.getId() %> </td>
			<td><%= book.getBook_name() %> </td>
			<td><%= book.getAuthor_name() %></td>
		</tr>
			<%	}	%>
	</table>
	
	<br> <br>
	<a href="libHome.jsp">Librarian Home Page</a>

</body>
</html>