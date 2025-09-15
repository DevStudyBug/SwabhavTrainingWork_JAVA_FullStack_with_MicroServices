<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.CRUDtest.model.DatabaseConnection"%>

<!DOCTYPE html>
<html>
<head>
<title>update</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));

	String name = request.getParameter("name");
	String department = request.getParameter("department");
	String email = request.getParameter("email");
	double salary = Double.parseDouble(request.getParameter("salary"));
	Connection conn = DatabaseConnection.getConnection();
	Statement st = conn.createStatement();
	st.executeUpdate("update employees set name='" + name + "', department='" + department + "', email='" + email + "', salary=" + salary + " where id=" + id);
	response.sendRedirect("index.jsp");
	%>
</body>
</html>