<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> Employee Salary in Different Currencies:</h2>

  <c:set var="salary" value="85000.89" />

  <p>US: 
    <fmt:setLocale value="en_US" />
    <fmt:formatNumber value="${salary}" type="currency" />
  </p>

  <p>Japan: 
    <fmt:setLocale value="ja_JP" />
    <fmt:formatNumber value="${salary}" type="currency" />
  </p>

  <p>Germany: 
    <fmt:setLocale value="de_DE" />
    <fmt:formatNumber value="${salary}" type="currency" />
  </p>


</body>
</html>