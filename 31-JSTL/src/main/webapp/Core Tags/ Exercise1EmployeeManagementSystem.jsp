<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Management System</title>
</head>
<body>
<h2>Employee Salary Check</h2>

<form method="post">
    Enter Salary: <input type="number" name="salary" required>
    <input type="submit" value="Check Bonus">
</form>

<core:if test="${not empty param.salary }">
<core:set var ="salary" value="${param.salary }"></core:set>
<p>Employee Salary: <b></b><core:out value="${salary}" />

<core:choose>
            <core:when test="${salary > 50000}">
                <p>Eligible for 10% Bonus</p>
            </core:when>
            <core:when test="${salary >= 30000 && salary <= 50000}">
                <p>Eligible for 5% Bonus</p>
            </core:when>
            <core:otherwise>
                <p>No Bonus</p>
            </core:otherwise>
        </core:choose>


</core:if>


</body>
</html>

<!-- 
<!-- 
Task:
 Create a JSP page using JSTL where an employee’s salary is checked.
 If salary > 50,000 → print “Eligible for 10% Bonus”.
 If salary between 30,000–50,000 → print “Eligible for 5% Bonus”.
 Otherwise, print “No Bonus”.
 Use <c:choose> with <c:when> and <c:otherwise>.
✅ Hint: You’ll need <c:set> to store salary and <c:choose> for decision-making. --> 