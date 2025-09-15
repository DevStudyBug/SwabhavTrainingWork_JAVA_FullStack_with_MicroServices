<%@page import="javax.xml.crypto.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.CRUDtest.model.DatabaseConnection"%>

<!DOCTYPE html>
<html>
<head>

<title>View Employee Details</title>
</head>
<body>
	<table>
		<th>ID</th>
		<th>Name</th>
		<th>Email</th>
		<th>Department</th>
		<th>Salary</th> 
		<% Connection conn = DatabaseConnection.getConnection();
		Statement st = conn.createStatement(); 
		ResultSet rs = st.executeQuery("select * from employees");
		%>
		<%
		while(rs.next()){
			%>	
		
		<tr>
		<td><%=rs.getInt("id")%></td>
		<td><%=rs.getString("name")%></td>
		<td><%=rs.getString("department")%></td>
		<td><%=rs.getDouble("salary")%></td>
	</tr>	
		<% }%>
		<tr>
		</tr>
	</table>

<br></br>
<form action="" method ="post">
Enter ID: <input type ="number" name = "id" required>

<button type ="submit" formaction ="delete.jsp" onlick = "Are u sure yes/no">Delete
</button>
<button type ="submit" formaction ="saveEdit.jsp" onlick ="Ready to update">
Update</button>

</form>
<a href ="employeeForm.jsp">Add another employee</a>


</body>
</html>
