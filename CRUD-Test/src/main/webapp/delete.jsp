<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import ="com.CRUDtest.model.DatabaseConnection" %>

<!DOCTYPE html>
<html>
<head>

<title>Delete Employee Data</title>
</head>
<body>
<%
int id = Integer.parseInt(request.getParameter("id"));
Connection conn = DatabaseConnection.getConnection();
Statement st = conn.createStatement();
st.executeUpdate("delete from employees where id="+ id);
response.sendRedirect("index.jsp");
%>

</body>
</html>