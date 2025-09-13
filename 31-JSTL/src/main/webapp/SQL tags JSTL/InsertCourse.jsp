<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head>
    <title>Insert Course</title>
</head>
<body>

<sql:setDataSource 
    var="db" 
    driver="com.mysql.cj.jdbc.Driver"
    url="jdbc:mysql://localhost:3306/schooldb"
    user="root" 
    password="anshika" />

<!-- Insert new course -->
<sql:update dataSource="${db}" var="count">
    INSERT INTO courses (course_name, duration) VALUES ('Web Development', '6 months');
</sql:update>

<c:if test="${count > 0}">
    <h3 style="color:green;"> Course inserted successfully!</h3>
</c:if>

</body>
</html>