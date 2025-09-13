<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Demo</title>
</head>
<body>
<h2>This is JSP Demo</h2>


<%
String name = "Amit";
out.println("Hello " + name +", welcome to JSP demo page");
int len = name.length();
%>


<%= len %>
</body>
</html>