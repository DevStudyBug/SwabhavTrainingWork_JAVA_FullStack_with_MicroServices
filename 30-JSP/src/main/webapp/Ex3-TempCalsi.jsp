<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Temperature Converter</h2>

    <form method="post">
        Enter Value: <input type="number" step="0.1" name="temp" required>
        <br><br>
        Convert To: 
        <select name="type">
         <option value="">Select</option>
            <option value="CtoF">Celsius To Fahrenheit</option>
            <option value="FtoC">Fahrenheit To Celsius</option>
        </select>
        <br><br>
        <input type="submit" value="Convert">
    </form>


    <%! 
        public double celsiusToFahrenheit(double c){
            return (c * 9/5) + 32;
        }

        public double fahrenheitToCelsius(double f){
            return (f - 32) * 5/9;
        }
    %>

    <%
        String tempStr = request.getParameter("temp");
        String type = request.getParameter("type");

        if(tempStr != null && type != null){
            double value = Double.parseDouble(tempStr);
            double result = 0.0;
            String msg = "";

            if(type.equals("CtoF")){
                result = celsiusToFahrenheit(value);
                msg = value + " °C = " + result + " °F";
            } else if(type.equals("FtoC")){
                result = fahrenheitToCelsius(value);
                msg = value + " °F = " + result + " °C";
            }
    %>
            <h3><%= msg %></h3>
    <%
        }
    %>


</body>
</html>