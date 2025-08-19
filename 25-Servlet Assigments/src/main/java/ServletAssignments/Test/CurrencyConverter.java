package ServletAssignments.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/convert")
	public class CurrencyConverter extends HttpServlet {

	    private Map<String, Double> conversionRates;

	    @Override
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	        conversionRates = new HashMap<>();

	        // Static conversion rates (from -> to)
	        conversionRates.put("USDINR", 83.0);
	        conversionRates.put("INRUSD", 0.012);
	        conversionRates.put("USDEUR", 0.91);
	        conversionRates.put("EURUSD", 1.1);
	        conversionRates.put("INREUR", 0.011);
	        conversionRates.put("EURINR", 88.0);

	        System.out.println("CurrencyConverter Servlet initialized.");
	    }

	    @Override
	    public void destroy() {
	        System.out.println("CurrencyConverter Servlet destroyed.");
	        conversionRates.clear();
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String amountStr = request.getParameter("amount");
	        String from = request.getParameter("from");
	        String to = request.getParameter("to");

	        out.println("<html><body>");
	        out.println("<h2>Currency Conversion Result</h2>");

	        if (amountStr == null || from == null || to == null ||
	            amountStr.isEmpty() || from.isEmpty() || to.isEmpty()) {
	            out.println("<p style='color:red;'>Error: All fields are required.</p>");
	        } else if (from.equals(to)) {
	            out.println("<p style='color:red;'>Error: Source and destination currencies cannot be the same.</p>");
	        } else {
	            try {
	                double amount = Double.parseDouble(amountStr);
	                String key = from + to;
	                Double rate = conversionRates.get(key);

	                if (rate != null) {
	                    double result = amount * rate;
	                    out.printf("<p>%.2f %s = %.2f %s</p>", amount, from, result, to);
	                } else {
	                    out.println("<p style='color:red;'>Error: Conversion rate not available for " + from + " to " + to + ".</p>");
	                }

	            } catch (NumberFormatException e) {
	                out.println("<p style='color:red;'>Error: Invalid amount entered.</p>");
	            }
	        }

	        out.println("<br><a href='CurrencyConverter.html'>Back to Converter</a>");
	        out.println("</body></html>");
	    }
	}