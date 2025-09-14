<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*,com.aurionpro.CRUD.model.DatabaseConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Employee</title>
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

<h1>Employee managment</h1>
<form action="addEmployee.jsp">
Name:<input type ="text" name ="name" required> <br></br>
Department: <input type ="text" name="department" required> <br></br>
Salary:<input type="text" name="salary" required > <br></br>

<input type="submit" value="Add Employee"><br></br>
    </form>

    <br>
   
</form>
<a href="viewEmployees.jsp">View Employees</a>
</div>
</body>
</html>







