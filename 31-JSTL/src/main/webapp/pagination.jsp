<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Pagination with JSTL</title>
<style>
  table { border-collapse: collapse; width: 50%; margin: 20px auto; }
  th, td { border: 1px solid black; padding: 8px; text-align: center; }
  a { margin: 0 5px; text-decoration: none; }
  .active { font-weight: bold; color: red; }
</style>
</head>
<body>
<h2 align="center">Employee Records</h2>

<table>
<tr><th>ID</th><th>Name</th><th>Department</th></tr>

<c:forEach var="emp" items="${employeeList}">
    <tr>
        <td>${emp.id}</td>
        <td>${emp.name}</td>
        <td>${emp.department}</td>
    </tr>
</c:forEach>
</table>

<div align="center">

    <!-- Previous -->
    <c:if test="${currentPage > 1}">
        <a href="PaginationServlet?page=${currentPage - 1}">Previous</a>
    </c:if>

    <!-- Page numbers -->
    <c:forEach begin="1" end="${noOfPages}" var="i">
        <c:choose>
            <c:when test="${i == currentPage}">
                <span class="active">${i}</span>
            </c:when>
            <c:otherwise>
                <a href="PaginationServlet?page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <!-- Next -->
    <c:if test="${currentPage < noOfPages}">
        <a href="PaginationServlet?page=${currentPage + 1}">Next</a>
    </c:if>

</div>
</body>
</html>