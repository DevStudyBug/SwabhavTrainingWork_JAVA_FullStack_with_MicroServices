<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="java.util.Random" %>
    
<!DOCTYPE html>
<html>
<head>
<title>Random Quote Generator</title>
</head>
<body>
 <h2>Motivational Quote</h2>
 <%
 String[] quotes = {
         "Push yourself, because no one else is going to do it for you.",
         "Great things never come from comfort zones.",
         "Dream it. Wish it. Do it.",
         "Success does not just find you. You have to go out and get it.",
         "The harder you work for something, the greater you will feel when you achieve it.",
         "Do not stop when you are tired. Stop when you are done.",
     };
     Random rand = new Random();
     int index = rand.nextInt(6);
 %>
 
 <p><b>Today's Quote:</b> <%= quotes[index] %></p>
 
 <%--<p><b>Quote:</b> <%= quotes[new java.util.Random().nextInt(6)] %></p> --%>

</body>
</html>