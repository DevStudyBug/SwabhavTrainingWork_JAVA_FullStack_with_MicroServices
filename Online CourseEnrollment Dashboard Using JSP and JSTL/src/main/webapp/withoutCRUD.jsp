<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Course Dashboard</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f7f9fc;
	margin: 20px;
}

.dashboard-title {
	text-align: center;
	font-size: 22px;
	font-weight: bold;
	color: #333;
	margin-bottom: 25px;
}

.student-card {
	background: #fff;
	border: 1px solid #ddd;
	padding: 15px;
	margin-bottom: 20px;
	border-radius: 8px;
	box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.1);
}

.student-card h3 {
	margin: 0 0 10px 0;
	color: #444;
}

.student-card p {
	margin: 5px 0;
	color: #555;
}

.courses-list {
	margin-top: 10px;
	padding-left: 20px;
}

.warning {
	color: red;
	font-weight: bold;
}

.no-records {
	text-align: center;
	font-style: italic;
	color: #777;
}
</style>
</head>
<body>

	<sql:setDataSource var="db" 
	    driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/course_dashboard" 
		user="root"
		password="anshika" />

	<sql:query var="students" dataSource="${db}">
	SELECT * FROM students;
	</sql:query>

	<sql:query var="courses" dataSource="${db}">
	SELECT * FROM courses;
	</sql:query>

	<div class="dahboard-title">
		<h1>Online Course Dashboard</h1>
	</div>
	
	<c:choose>
		<c:when test="${students.rowCount > 0}">
			<c:forEach var="s" items="${students.rows}">
				<div class="student-card">
					<h3>${s.name}</h3>
					<p>
						<b>Email:</b> ${s.email}
					</p>
					<p>
						<b>Institutional Email?</b>
						<c:choose>
							<c:when test="${fn:contains(s.email, 'edu')}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose>
					</p>
					<p>
						<b>Join Date:</b>
						<fmt:formatDate value="${s.join_date}" pattern="MMM d, yyyy" />
					</p>

					<fmt:setLocale value="en_IN" />
					<p>
						<b>Fees Paid:</b>
						<fmt:formatNumber value="${s.fees_paid}" type="currency" />
					</p>

					<c:if test="${s.fees_paid lt 1000}">
						<p class="warning">Warning: Fees not fully paid!</p>
					</c:if>

					<p>
						<b>Courses Enrolled:</b>
					</p>
					<ul class="courses-list">
						<c:forEach var="c" items="${courses.rows}">
							<c:if test="${c.student_id == s.id}">
								<c:forEach var="course" items="${fn:split(c.course_list, ',')}">
									<li>${course}</li>
								</c:forEach>
							</c:if>
						</c:forEach>
					</ul>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<p class="no-records">No student records found.</p>
		</c:otherwise>
	</c:choose>
</body>
</html>