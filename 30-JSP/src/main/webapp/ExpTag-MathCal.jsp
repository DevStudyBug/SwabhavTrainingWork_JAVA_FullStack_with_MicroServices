<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Math calculator</title>
</head>
<body>
<h2>Math calculator</h2>
    <form method="post">
        Enter first number: <input type="number" name="a" required><br><br>
        Enter second number: <input type="number" name="b" required><br><br>
        <input type="submit" value="Calculate">
    </form>

    <%
        String aParam = request.getParameter("a");
        String bParam = request.getParameter("b");

        if (aParam != null && bParam != null) {
            int a = Integer.parseInt(aParam);
            int b = Integer.parseInt(bParam);
    %>
            <h3>Results:</h3>
            <p>Sum = <%= a + b %></p>
            <p>Difference = <%= a - b %></p>
            <p>Product = <%= a * b %></p>
            <p>Division = <%= (double)a / b %></p>
    <%
        }
    %>
<%-- <% int a=15 , b=4; %>
<p>First Number = <%=a%> and Second Number = <%=b%> Calculation </p>
<p>Sum = <%=a + b %></p>
<p>Difference = <%=a - b %></p>
<p>Multiplication = <%=a * b %></p>
<p>Division = <%=a * b %></p> --%>
</body>
</html>