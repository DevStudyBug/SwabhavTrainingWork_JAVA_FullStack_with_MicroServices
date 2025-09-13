<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="i" begin="1" end="10">
 Number: ${i} <br>
</c:forEach>

odd number:
<c:forEach var="i" begin="1" end="10">
<c:if test="${ i%2!=0}">
 <c:out value="${i}"></c:out>
</c:if>
</c:forEach> <br>

<c:forEach var="i" begin="1" end="10">
 Number: ${11-i} <br>
</c:forEach>
</body>
</html>