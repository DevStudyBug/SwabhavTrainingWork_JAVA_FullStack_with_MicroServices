package ServletAssignments.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class WeatherInfo  extends HttpServlet{
	private static final Map<String, String[]> weatherData = new HashMap<>();

	static {
		weatherData.put("Delhi", new String[] { "35°C", "50%", "Sunny" });
		weatherData.put("Mumbai", new String[] { "30°C", "70%", "Humid" });
		weatherData.put("Chennai", new String[] { "33°C", "60%", "Cloudy" });
		weatherData.put("Bangalore", new String[] { "28°C", "55%", "Rainy" });
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Server created");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String city = req.getParameter("city");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		out.println("<html><head><title>Weather Info</title></head><body>");

		if (city == null || city.trim().isEmpty()) {
			out.println("<h2>Error: City name is required!</h2>");
		} else {
			String[] data = weatherData.get(city);


			if (data != null) {
				out.println("<h2>Weather Info for " + city + "</h2>");
				out.println("<p><strong>Temperature:</strong> " + data[0] + "</p>");
				out.println("<p><strong>Humidity:</strong> " + data[1] + "</p>");
				out.println("<p><strong>Forecast:</strong> " + data[2] + "</p>");
			} else {
				out.println("<h2>No data available for '" + city + "'</h2>");
			}
		}

		out.println("</body></html>");
	}

	@Override
	public void destroy() {
		System.out.println("Server closed");
	}
}

//🧾 Assignment 1: Weather Info Servlet (Weather Domain)
//Problem Statement:
//Create a servlet /weather that accepts a city name as a parameter and displays dummy
//weather data for that city.
//Requirements:
// Accept a query parameter city.
// Validate that the city name is not empty.
// Display hardcoded temperature, humidity, and forecast info based on city name.
// Return error message if city is invalid.
//Sample URL:
//http://localhost:8080/weather?city=Delhi
