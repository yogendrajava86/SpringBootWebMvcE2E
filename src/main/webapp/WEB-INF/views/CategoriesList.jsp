<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<h3>WELCOME TO CATEGORY DATA</h3>
<table>
	<tr>
		<th>ID</th>		
		<th>NAME</th>		
		<th>OPERATIONS</th>
	</tr>
	
	<c:forEach items="${list}" var="ob">
		<tr>
			<td><c:out value="${ob.catId}"/> </td>
			<td><c:out value="${ob.catName}"/> </td>			
			<td>
				<a href="deletecat?id=${ob.catId}">DELETE</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>