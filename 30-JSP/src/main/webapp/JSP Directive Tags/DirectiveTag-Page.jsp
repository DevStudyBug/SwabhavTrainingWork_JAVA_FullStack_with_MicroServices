<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page import="java.util.*, java.text.*"%>
<%@ page session="true"%>
<%@ page buffer="16kb"%>
<%@ page autoFlush="true"%>
<%@ page isThreadSafe="true"%>
<%@ page errorPage="error.jsp"%>
<%@ page isELIgnored="false"%>
<%@ page info="This page demonstrates JSP page directive"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page Directive Example</title>
</head>
<body>
	<h1>Welcome to JSP Page Directive Demo</h1>

	<%
	// Using imported classes
	Date now = new Date();
	out.println("<p>Current Date and Time: " + now + "</p>");
	%>
	<%
	String pageInfo = "This page demonstrates JSP page directive";
	%>
	<p>
		Page Info:
		<%=pageInfo%></p>
	<%--  <p>Page Info: <%= application.getAttribute("javax.servlet.jsp.jspInfo") %></p> --%>
</body>
</html>