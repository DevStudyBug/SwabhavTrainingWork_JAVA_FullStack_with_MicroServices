<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Factorial of a number</h2>

	<form method="post">
		Enter a number: <input type="number" name="num" required="required">
		<input type="submit" value="Calculate">
	</form>

	<%!public int factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact = fact * i;
		}
		return fact;
	}%>
	<%
	String s = request.getParameter("num");
	if (s != null) {
		int num = Integer.parseInt(s);
		int result = factorial(num);
	%>
	<h3>
		Factorial of
		<%=num%>
		is
		<%=result%></h3>
	<%
	}
	%>

</body>
</html>

<%-- 
Exercise 1: Factorial Calculator Method
 Declare a method inside <%! ... %>:
 public int factorial(int n){
 int fact=1;
 for(int i=1;i<=n;i++){ fact*=i; }
 return fact;
 }
 In the JSP, call this method for n=5.
 Print result → Factorial of 5 = 120 --%>