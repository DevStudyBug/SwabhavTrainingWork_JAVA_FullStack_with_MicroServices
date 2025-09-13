<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> this is core tag</h2>
<core:set var="num" value ="45"></core:set>

<h3>  <core:out value="${num }"></core:out>
</h3>

<h2>✈️ Available Packages</h2>
 <core:set var="packages" value="Paris,London,NewYork,Tokyo" />
 <core:forTokens var="city" items="${packages}" delims="," >
 Destination: ${city} <br>
 </core:forTokens>
</body>
</html>