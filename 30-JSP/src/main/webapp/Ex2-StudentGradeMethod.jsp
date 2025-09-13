<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Student Grade Checker </h2>
	
	<form method="post">
	Enter Marks: <input type="number" name="marks" required="required">
	<input type="submit" value="Calculate">
	</form>
	
	<%!
	public String getGrade(int marks) {
	    if (marks >= 90 && marks <= 100) {
	        return "A";
	    } else if (marks >= 70 && marks < 90) {
	        return "B";
	    } else if (marks >= 50 && marks < 70) {
	        return "C";
	    } else if (marks >= 0 && marks < 50) {
	        return "Fail";
	    } else {
	        return "Invalid Marks"; 
	    }
	}

	%>
	
	<%
	String s = request.getParameter("marks");
	if(s != null){
		int marks = Integer.parseInt(s);
		String grade = getGrade(marks);
	%>	
	<h3>Grade is : <%=grade %></h3>
	<% 
	}
	%>
</body>
</html>


<!-- Exercise 2: Student Grade Method
 Declare a method getGrade(int marks) that returns "A", "B", "C", "Fail"
based on marks.
 Call this method for a student with marks = 72.
 Print → "Grade: B". -->
