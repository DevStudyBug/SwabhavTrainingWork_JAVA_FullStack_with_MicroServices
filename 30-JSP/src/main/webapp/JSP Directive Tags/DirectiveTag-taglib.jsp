<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="header.jsp" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Taglib Example</title>
</head>
<body>

<div>
    <h2>Main Content Section</h2>
    <c:set var="username" value="Anshika" />
    <c:set var="now" value="<%= new java.util.Date() %>" />

    <c:if test="${not empty username}">
        <p>Hello, ${username}! Welcome to the JSP Taglib demo.</p>
    </c:if>

    <p>Current Date and Time: 
        <fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm:ss"/>
    </p>

    <c:choose>
        <c:when test="${username eq 'Admin'}">
            <p>Admin Panel Access</p>
        </c:when>
        <c:otherwise>
            <p>User Dashboard Access</p>
        </c:otherwise>
    </c:choose>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
