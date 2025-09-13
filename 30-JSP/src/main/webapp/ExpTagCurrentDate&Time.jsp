<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Date, java.time.Year" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Date & Time</title>
</head>
<body>
<h2>Current Date & Time</h2>
<p>Current date : <%= new Date() %></p>
<p>Current year : <%= Year.now() %></p>

<!-- or -->
<h2>Direct Printing Example</h2>

    <p>Current Date: <%= new java.util.Date() %></p>
    <p>Current Year: <%= java.time.Year.now() %></p>

</body>
</html>