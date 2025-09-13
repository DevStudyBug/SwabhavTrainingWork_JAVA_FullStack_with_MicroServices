<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <title>Multiplication Table Generator</title>
</head>
<body>
    <h2>Multiplication Table Generator</h2>

    <form method="post">
        Enter a number: 
        <input type="number" name="number" required>
        <input type="submit" value="Generate Table">
    </form>

    <%
        String numParam = request.getParameter("number");

        if (numParam != null) {
            int number = Integer.parseInt(numParam);
    %>
            <h3>Multiplication Table for <%= number %>:</h3>
            <%
                for (int i = 1; i <= 10; i++) {
            %>
                <p><%= number %> x <%= i %> = <%= number * i %></p>
            <%
                }
            %>
    <%
        }
    %>
</body>
</html>