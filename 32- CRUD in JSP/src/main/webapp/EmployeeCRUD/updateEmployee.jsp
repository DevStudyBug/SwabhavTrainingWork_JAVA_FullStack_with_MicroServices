<%@ page import="java.sql.* , com.aurionpro.CRUD.model.DatabaseConnection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Employee</title>
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Connection conn = DatabaseConnection.getConnection();
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery("select * from employee where id=" + id);
    if(rs.next()){
%>
    <h2>Update Employee</h2>
    
    <form action="saveUpdate.jsp" method="post">
        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
        Name: <input type="text" name="name" value="<%= rs.getString("name") %>"><br><br>
        Department: <input type="text" name="department" value="<%= rs.getString("department") %>"><br><br>
        Salary: <input type="number" step="0.01" name="salary" value="<%= rs.getDouble("salary") %>"><br><br>
        <button type="submit">Save</button>
    </form>
<% } else { %>
    <p>No employee found with ID <%= id %></p>
<% } %>
</body>
</html>
