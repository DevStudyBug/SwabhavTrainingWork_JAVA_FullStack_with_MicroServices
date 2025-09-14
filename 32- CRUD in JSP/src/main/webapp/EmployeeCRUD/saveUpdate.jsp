<%@ page import="java.sql.* , com.aurionpro.CRUD.model.DatabaseConnection"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String name = request.getParameter("name");
    String department = request.getParameter("department");
    double salary = Double.parseDouble(request.getParameter("salary"));

    Connection conn = DatabaseConnection.getConnection();
    Statement st = conn.createStatement();
    st.executeUpdate("update employee set name='" + name + "', department='" + department + "', salary=" + salary + " where id=" + id);
    response.sendRedirect("viewEmployees.jsp");
%>
