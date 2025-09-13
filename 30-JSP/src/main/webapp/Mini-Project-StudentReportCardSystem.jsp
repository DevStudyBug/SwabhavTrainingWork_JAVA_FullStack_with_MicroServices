<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dynamic Report Card</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
    <h2>Student Report Card</h2>
    
    <form method="post">
        <label>Student Name:</label>
        <input type="text" name="name" required>
        
        <label>Roll Number:</label>
        <input type="text" name="roll" required>
        
        <label>Marks in Physics:</label>
        <input type="number" name="sub1" min="0" max="100" required>
        
        <label>Marks in Chemistry:</label>
        <input type="number" name="sub2" min="0" max="100" required>
        
        <label>Marks in Maths:</label>
        <input type="number" name="sub3" min="0" max="100" required>
        
        <input type="submit" value="Generate Report Card">
    </form>
    
<%
    String name = request.getParameter("name");
    String roll = request.getParameter("roll");
    String s1 = request.getParameter("sub1");
    String s2 = request.getParameter("sub2");
    String s3 = request.getParameter("sub3");

    if(name != null && roll != null && s1 != null && s2 != null && s3 != null) {
        try {
            int m1 = Integer.parseInt(s1);
            int m2 = Integer.parseInt(s2);
            int m3 = Integer.parseInt(s3);
            
            if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100) {
                out.println("<p style='color:red; text-align:center;'>Invalid marks! Enter 0-100 only.</p>");
            } else {
                int total = m1 + m2 + m3;
                double percentage = total / 3.0;
                String grade;

                if (percentage >= 90 && percentage <= 100) {
                    grade = "A+";
                } else if (percentage >= 75) {
                    grade = "A";
                } else if (percentage >= 60) {
                    grade = "B";
                } else if (percentage >= 40) {
                    grade = "C";
                } else {
                    grade = "Fail";
                }
%>
    <div class="report-card">
    <h3>Report Card</h3>
    <p><b>Name:</b> <%= name %></p>
    <p><b>Roll No:</b> <%= roll %></p>

    <p><b>Physics Marks:</b> <%= m1 %> 
        <% if(m1 < 40) { %>
            <span style="color:red;">(Failed)</span>
        <% } %>
    </p>

    <p><b>Chemistry Marks:</b> <%= m2 %> 
        <% if(m2 < 40) { %>
            <span style="color:red;">(Failed)</span>
        <% } %>
    </p>

    <p><b>Maths Marks:</b> <%= m3 %> 
        <% if(m3 < 40) { %>
            <span style="color:red;">(Failed)</span>
        <% } %>
    </p>

    <p><b>Total:</b> <%= total %></p>
    <p><b>Percentage:</b> <%= String.format("%.2f", percentage) %> %</p>
    <p><b>Grade:</b> <%= grade %></p>

    <!-- Search Another Button -->
    <form method="get">
        <input type="submit" value="Search Another Student">
    </form>
</div>
    
<%
            }
        } catch(NumberFormatException e) {
            out.println("<p style='color:red; text-align:center;'>Please enter valid numeric marks!</p>");
        }
    }
%>

</div>
</body>
</html>
