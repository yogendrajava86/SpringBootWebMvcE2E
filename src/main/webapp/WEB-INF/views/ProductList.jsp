<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
<h3>WELCOME TO PRODUCT DATA</h3>
<hr/>
<div style="text-align:center"><a href="add">Add Product</a></div>
${message}
<table border="1" width="100%">
	<tr>
		<th>ID</th>
		<th>CODE</th>
		<th>NAME</th>
		<th>COST</th>
		<th>GST</th>
		<th>IMAGE</th>
		<th>CATEGORY</th>
		<th>DETAIL</th>
		<th colspan="2">OPERATIONS</th>
	</tr>
	
	<c:forEach items="${list}" var="ob">
		<tr>
			<td><c:out value="${ob.prodId}"/> </td>
			<td><c:out value="${ob.prodCode}"/> </td>
			<td><c:out value="${ob.prodName}"/> </td>
			<td><c:out value="${ob.prodCost}"/> </td>
			<td><c:out value="${ob.gst}"/> </td>
			<td><img src="/myapp/images/uploadingDir/${ob.images[0]}" width="75" height="50"/> </td>
			<td>
				<c:forEach items="${ob.prodCategory}" var="ca">
					<c:out value="${ca.catName}"/>
				</c:forEach>
			
			 </td>
			<td><c:out value="${ob.prodDetail}"/> </td>
			<td>
				<a href="delete?id=${ob.prodId}">DELETE</a>
			</td>
			<td>
				<a href="edit?id=${ob.prodId}">EDIT</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>




