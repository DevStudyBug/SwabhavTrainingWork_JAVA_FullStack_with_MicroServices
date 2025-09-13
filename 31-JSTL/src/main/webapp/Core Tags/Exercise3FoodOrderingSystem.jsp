<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Food Ordering System</title>
</head>
<body>

	<c:if test="${empty menu}">
		<c:set var="menu" value="Pizza,Burger,Pasta,Sandwich" />
	</c:if>

	<h2>Available Food Menu</h2>
	<ul>
		<c:forTokens items="${menu}" delims="," var="item">
			<li>${item}</li>
		</c:forTokens>
	</ul>

	<form method="post">
		<input type="submit" name="removeBtn" value="Remove Menu">
	</form>

	<c:if test="${param.removeBtn ne null}">
		<c:remove var="menu" />
		<h3>After Removing Menu Variable:</h3>
    Menu value = ${menu}
</c:if>

</body>
</html>
