<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<head>
<title>Teacher Lookup</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f8f9fa;
	text-align: center;
	padding: 10px;
	margin: 5px;
}
</style>
</head>
<body>

	<h2>Find Teachers by Subject</h2>

	<form method="get">
		Enter Subject: <input type="text" name="subject" required> <input
			type="submit" value="Search">
	</form>


	<c:if test="${not empty param.subject}">

		<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/schooldb" user="root"
			password="anshika" />

		<sql:query dataSource="${db}" var="teachers">
       SELECT name, subject FROM teachers WHERE subject = ?
       <sql:param value="${param.subject}" />
		</sql:query>

		<h3>Teachers for Subject: ${param.subject}</h3>
		<c:choose>
			<c:when test="${teachers.rowCount > 0}">
				<ul>
					<c:forEach var="row" items="${teachers.rows}">
						<li>${row.name}-> ${row.subject}</li>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p style="color: red;">No teachers found for this subject.</p>
			</c:otherwise>
		</c:choose>
	</c:if>

</body>
</html>