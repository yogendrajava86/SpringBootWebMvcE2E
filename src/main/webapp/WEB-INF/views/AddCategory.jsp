<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<h3>WELCOME TO CATEGORY REGISTER</h3>
<form:form action="savecat" method="POST" modelAttribute="categories">
<pre>
 Category Name  : <form:input path="catName"/> 

   <input type="submit" value="CREATE CATEGORY"/> 		
</pre>
</form:form>
${message}
</body>
</html>