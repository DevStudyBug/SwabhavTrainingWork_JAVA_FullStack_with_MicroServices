package com.bookverse;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminConfigServlet extends HttpServlet {
	    
	    private String storeName;
	    private String adminEmail;
	    private String category;
	    
	    @Override
	    public void init(ServletConfig config) throws ServletException {
	        super.init(config);
	        
	        // Read ServletConfig parameters - specific to this servlet instance
	        storeName = config.getInitParameter("storeName");
	        adminEmail = config.getInitParameter("adminEmail");
	        category = config.getInitParameter("category");
	    }
	    
	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	            throws ServletException, IOException {
	        
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        ServletContext context = getServletContext();
	        ServletConfig config = getServletConfig();
	        
	        // Get global context information // type casting
	        Integer totalVisitors = (Integer) context.getAttribute("totalVisitors");
	        String appVersion = context.getInitParameter("appVersion");
	        Integer fictionCount = (Integer) context.getAttribute("fictionCount");
	        Integer scienceCount = (Integer) context.getAttribute("scienceCount");
	        Integer techCount = (Integer) context.getAttribute("techCount");
	        
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Admin Configuration Panel</title>");
	        
	        out.println("<style>");
	        out.println("body { font-family: Arial, sans-serif; margin: 40px; background-color: #f8f9fa; }");
	        out.println(".container { max-width: 700px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
	        out.println("h1 { color: #e74c3c; text-align: center; }");
	        out.println(".config-section { background: #fff3cd; padding: 15px; border-radius: 5px; margin: 20px 0; border-left: 4px solid #ffc107; }");
	        out.println(".stats-section { background: #d1ecf1; padding: 15px; border-radius: 5px; margin: 20px 0; border-left: 4px solid #17a2b8; }");
	        out.println("table { width: 100%; border-collapse: collapse; margin: 10px 0; }");
	        out.println("th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }");
	        out.println("th { background-color: #f2f2f2; }");
	        out.println(".back-link { display: inline-block; margin-top: 20px; padding: 10px 20px; background: #6c757d; color: white; text-decoration: none; border-radius: 5px; }");
	        out.println(".back-link:hover { background: #5a6268; }");
	        out.println("</style>");
	        out.println("</head>");
	        
	        out.println("<body>");
	        out.println("<div class='container'>");
	        out.println("<h1>🔹 Admin Panel</h1>");
	        
	        // ServletConfig Information
	        out.println("<div class='config-section'>");
	        out.println("<h3>🔧 Servlet Configuration (ServletConfig)</h3>");
	        out.println("<table>");
	        out.println("<tr><th>Parameter</th><th>Value</th></tr>");
	        out.println("<tr><td><strong>Configured Category:</strong></td><td>" + category + "</td></tr>");
	        out.println("<tr><td><strong>Store Name:</strong></td><td>" + storeName + "</td></tr>");
	        out.println("<tr><td><strong>Contact Admin:</strong></td><td>" + adminEmail + "</td></tr>");
//	        out.println("<tr><td><strong>Servlet Name:</strong></td><td>" + config.getServletName() + "</td></tr>");
	        out.println("</table>");
	        out.println("</div>");
	        
	        // ServletContext Information
	        out.println("<div class='stats-section'>");
	        out.println("<h3>🌐 Global Application Data (ServletContext)</h3>");
	        out.println("<table>");
	        out.println("<tr><th>Metric</th><th>Count</th></tr>");  // using ternary operator
	        out.println("<tr><td><strong>Total Visitors:</strong></td><td>" + (totalVisitors != null ? totalVisitors : 0) + "</td></tr>");
	        out.println("<tr><td><strong>Fiction Visitors:</strong></td><td>" + (fictionCount != null ? fictionCount : 0) + "</td></tr>");
	        out.println("<tr><td><strong>Science Visitors:</strong></td><td>" + (scienceCount != null ? scienceCount : 0) + "</td></tr>");
	        out.println("<tr><td><strong>Technology Visitors:</strong></td><td>" + (techCount != null ? techCount : 0) + "</td></tr>");
	        out.println("<tr><td><strong>App Version:</strong></td><td>" + appVersion + "</td></tr>");
	        out.println("</table>");
	        out.println("</div>");
	        
	        out.println("<a href='welcome' class='back-link'>← Back to Home</a>");
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");
	    }
	}
