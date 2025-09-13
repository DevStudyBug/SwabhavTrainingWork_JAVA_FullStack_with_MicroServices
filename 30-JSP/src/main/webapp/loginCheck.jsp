<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Check</title>
</head>
<body>
    <h2>Login Page</h2>

    <!-- Login Form -->
    <form method="post">
        Username: <input type="text" name="username" required><br><br>
        Password: <input type="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>

    <%
        String correctUser = "admin";
        String correctPass = "12345";

        String uname = request.getParameter("username");
        String pass = request.getParameter("password");

        if (uname != null && pass != null) {
            if (uname.equals(correctUser) && pass.equals(correctPass)) {
    %>
                <h3>Welcome, <%= correctUser %>!</h3>
    <%
            } else {
    %>
                <h3>Invalid Credentials</h3>
    <%
            }
        }
    %>
</body>
</html>