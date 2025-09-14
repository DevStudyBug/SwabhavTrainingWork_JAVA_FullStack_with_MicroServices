<%@ page import="java.sql.* , com.aurionpro.CRUD.model.DatabaseConnection"%>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Connection conn = DatabaseConnection.getConnection();
    Statement st = conn.createStatement();
    st.executeUpdate("delete from employee where id=" + id);

    response.sendRedirect("viewEmployees.jsp");
%>
