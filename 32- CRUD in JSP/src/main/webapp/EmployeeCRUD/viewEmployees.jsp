<%@ page
	import="java.sql.* , com.aurionpro.CRUD.model.DatabaseConnection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Employee</title>
<style>
.center-box {
	width: 300px;
	margin: 100px auto;
	padding: 20px;
	border: 1px solid black;
}
</style>
</head>
<body>
	<div class="center-box">
		<h2>Employee List</h2>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Department</th>
				<th>Salary</th>
			</tr>
			<%
			Connection conn = DatabaseConnection.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from employee");
			while (rs.next()) {
			%>
			<tr>
				<td><%=rs.getInt("id")%></td>
				<td><%=rs.getString("name")%></td>
				<td><%=rs.getString("department")%></td>
				<td><%=rs.getDouble("salary")%></td>
			</tr>
			<%
			}
			%>
		</table>
		<br>

		<form method="post">
			<label for="id">Enter Employee ID: </label> <input type="number"
				name="id" required> <br>
			<br>
			<button type="submit" formaction="updateEmployee.jsp">Update</button>
			<button type="submit" formaction="deleteEmployee.jsp"
				onclick="return confirm('Are you sure you want to delete?')">
				Delete</button>
		</form>
		<br>
		 <a href="addEmployeeForm.jsp">Add Employee</a>
	</div>
</body>
</html>