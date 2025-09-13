<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
    <title>ATM Mini System</title>
</head>
<h2>ATM Mini System</h2>

    <form method="post">
        Enter Withdraw Amount: 
        <input type="number" name="withdrawAmount" required>
        <input type="submit" value="Withdraw">
    </form>

    <%
        int balance = 5000;

        String withdrawParam = request.getParameter("withdrawAmount");

        if (withdrawParam != null) {   
            int withdrawAmount = Integer.parseInt(withdrawParam);

            if (withdrawAmount <= balance) {
                balance -= withdrawAmount;
    %>
                <h3>Withdrawal Successful</h3>
                <p>Remaining Balance: <%= balance %></p>
    <%
            } else {
    %>
                <h3>Insufficient Funds</h3>
                <p>Available Balance: <%= balance %></p>
    <%
            }
        }
    %>
</body>
</html>