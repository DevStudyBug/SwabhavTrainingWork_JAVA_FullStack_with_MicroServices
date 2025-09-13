<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parsing and Formatting Numbers</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 30px;
}

h2 {
	color: darkblue;
}
</style>
</head>
<body>
	<h2>Formatted Numbers:</h2>

	<c:set var="numStr" value="12345.6789" />

	<fmt:parseNumber var="num" type="number" value="${numStr}" />

	<p>Original: ${num}</p>

	<p>
		Two Decimals:
		<fmt:formatNumber value="${num}" type="number" maxFractionDigits="2" />
	</p>
	
	<p>
		Currency (INR):
		<fmt:setLocale value="en_IN" />
		<fmt:formatNumber value="${num}" type="currency" />
	</p>

</body>
</html>