<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Form to collect user name -->
<form method="get" action="greet.jsp">
    Enter your name: <input type="text" name="name" />
    <input type="submit" value="Greet Me" />
</form>

<%
    // Read the name parameter from the request
    String name = request.getParameter("name");

    // Validate: non-null and not empty after trim
    if (name != null && !name.trim().isEmpty()) {
%>
    <h2>Hello, <%= name %>! Welcome to JSP learning.</h2>
<%
    }
%>
</body>
</html>