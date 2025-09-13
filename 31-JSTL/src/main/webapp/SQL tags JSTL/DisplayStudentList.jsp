<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student List</title>
  <style>
    body { font-family: Arial, sans-serif; margin: 30px; }
    h2 { color: darkblue; }
    table { border-collapse: collapse; width: 50%; }
    th, td { border: 1px solid black; padding: 8px; text-align: center; }
    th { background-color: #f2f2f2; }
  </style>
</head>
<body>
  <h2> Student List</h2>

  <sql:setDataSource 
    var="db" 
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/schooldb"
    user="root" 
    password="anshika" />
  
 <sql:query dataSource="${db}" var="result">
      SELECT id, name, age FROM students;
  </sql:query>

  <table>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Age</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
      <tr>
        <td>${row.id}</td>
        <td>${row.name}</td>
        <td>${row.age}</td>
      </tr>
    </c:forEach>
  </table>

</body>
</html>