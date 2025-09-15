<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import ="com.CRUDtest.model.DatabaseConnection" %>

<html>
<head>
    <title>Add Employee Details</title>
</head>

<%
String name = request.getParameter("name");
String department = request.getParameter("department");
String email = request.getParameter("email");
String salaryStr = request.getParameter("salary");
double salary = Double.parseDouble(salaryStr);
if(name!=null && department!=null && email!=null && salaryStr !=null)
{
	Connection conn = DatabaseConnection.getConnection();
	PreparedStatement ps = conn.prepareStatement("INSERT INTO employees (name, department, email, salary) VALUES(?,?,?,?)");
	ps.setString(1, name);
	ps.setString(2, department);
	ps.setString(3, email);
	ps.setDouble(4, salary);
	
	int i = ps.executeUpdate();
    if(i > 0) {
        out.println("<p>Employee Added Successfully!</p>");
    }
    else{
    	out.print("please fill all details!!");
    }
}


%>

<a href = "index.jsp">View Employee Details</a>
<br></br>
<a href = "employeeForm.jsp">Add Employee Details</a>

</html>