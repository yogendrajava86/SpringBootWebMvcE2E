<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    isELIgnored="false"
    %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
<style type="text/css">
.hidden{display:none;}
</style>
</head>
<body>
<h3>WELCOME TO PRODUCT REGISTER</h3>
<form:form action="save" method="POST" enctype="multipart/form-data" modelAttribute="product">
<pre>
 CODE  : <form:input path="prodCode"/>
 NAME  : <form:input path="prodName"/>
 COST  : <form:input path="prodCost"/>
 Category:<form:select path="prodCategory">
 			<c:forEach items="${categories}" var="cat">
 			<form:option value="${cat.catId}">${cat.catName}</form:option>
 			</c:forEach>
 		  </form:select>
 GST   : <form:select path="gst">
 			<form:option value="5">5%-SLAB</form:option>
 			<form:option value="12">12%-SLAB</form:option>
 			<form:option value="18">18%-SLAB</form:option>
 			<form:option value="22">22%-SLAB</form:option>
 			<form:option value="30">30%-SLAB</form:option>
 		</form:select> 
 SelPrice:<form:input path="prodSelPrice"/>		
 Detail : <form:textarea path="prodDetail"/>
 UploadImages:<form:input type="file"  path="files"  multiple="multiple"/>
 					<form:input  path="images"  cssClass="hidden"/>
   <input type="submit" value="CREATE PRODUCT"/> 		
</pre>
</form:form>
${message}
</body>
</html>