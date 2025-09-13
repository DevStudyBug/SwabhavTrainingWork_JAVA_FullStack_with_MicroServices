<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Date Formats </h2>
	<jsp:useBean id="today" class="java.util.Date" scope="page"></jsp:useBean>
	<p>Short:
		<fmt:formatDate value="${today}" type="date" dateStyle="short"/>	
	</p>
	<p>Medium:
		<fmt:formatDate value="${today}" type="date" dateStyle="medium"/>	
	</p>
	<p>Full:
		<fmt:formatDate value="${today}" type="date" dateStyle="full"/>	
	</p>

</body>
</html>