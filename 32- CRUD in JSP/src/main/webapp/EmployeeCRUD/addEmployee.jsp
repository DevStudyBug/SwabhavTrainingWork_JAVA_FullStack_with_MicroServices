<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*,com.aurionpro.CRUD.model.DatabaseConnection" %>

<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<%
    String name = request.getParameter("name");
    String dept = request.getParameter("department");
    String salary = request.getParameter("salary");

    if(name != null && dept != null && salary != null ) {
   
        Connection conn = null;
        PreparedStatement ps = null;
        
        try {
           
            conn = DatabaseConnection.getConnection();

            String sql = "INSERT INTO employee(name, department, salary) VALUES(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dept);
            ps.setDouble(3, Double.parseDouble(salary));

            int i = ps.executeUpdate();
            if(i > 0) {
                out.println("<p>Employee Added Successfully!</p>");
            } else {
                out.println("<p>Failed to add employee.</p>");
            }
        } catch(Exception e) {
            out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
        } finally {
            try { if(ps != null) ps.close(); } catch(Exception ex) {}
            try { if(conn != null) conn.close(); } catch(Exception ex) {}
        }
    } else {
        out.println("<p style='color:red;'>Please fill all fields.</p>");
    }
%>

<br></br>
<a href="addEmployeeForm.jsp">Add Another Employee</a> 
<br></br>
<a href="viewEmployees.jsp">View Employees</a>
</body>
</html>
