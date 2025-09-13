<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Online Course Portal</title>
</head>
<body>
	<h1>Online Course Portal</h1>
	<h2>Available Courses</h2>


	<c:set var="courses" value="Java,Python,Angular,Spring" />
	<form>
		<label for="courseSelect">Select a Course:</label> <select
			id="courseSelect" name="selectedCourse">
			<option value="">-- Choose a Course --</option>
			<c:forEach var="course" items="${courses}" varStatus="status">
				<option value="${course}">${status.count}. ${course}
					
					<c:if test="${course == 'Spring'}">
                        (Most Popular)
                    </c:if>
                    
				</option>
			</c:forEach>
		</select> <br>
		<br> <input type="submit" value="Enroll Now">
	</form>
	
	<c:if test="${not empty param.selectedCourse}">
		<h3 style="color: green;">
			You have successfully enrolled in
			<c:out value="${param.selectedCourse}" />
			!
		</h3>
	</c:if>


</body>
</html>
