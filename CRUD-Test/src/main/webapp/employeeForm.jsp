<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div> 
<h1>Employee Management System</h1>
<form  action = "create.jsp" method="post">
Name: <input type = "text" name ="name" required> <br></br>
Department: <input type = "text" name = "department" required> <br></br>
Email: <input type = "email" name ="email" required><br></br>
Salary: <input type ="number" name= "salary" required><br></br>
<input type = "submit" value= "Add Employee"> <br></br>
</form>
<a href = "index.jsp">View Employee Details</a>
</div>
</body>
</html>