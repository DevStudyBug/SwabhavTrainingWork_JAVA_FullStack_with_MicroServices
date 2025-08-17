package com.bookverse;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LandingServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        // Initialize visitor counts in ServletContext if not present
        ServletContext context = getServletContext();
        
        if (context.getAttribute("totalVisitors") == null) {
            context.setAttribute("totalVisitors", 0);
        }
        if (context.getAttribute("fictionCount") == null) {
            context.setAttribute("fictionCount", 0);
        }
        if (context.getAttribute("scienceCount") == null) {
            context.setAttribute("scienceCount", 0);
        }
        if (context.getAttribute("techCount") == null) {
            context.setAttribute("techCount", 0);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        ServletContext context = getServletContext();
        
        // Increment total visitors using synchronized block for thread safety
        synchronized (context) {
            Integer totalVisitors = (Integer) context.getAttribute("totalVisitors");
            totalVisitors = (totalVisitors == null) ? 1 : totalVisitors + 1;
            context.setAttribute("totalVisitors", totalVisitors);
        }
        
        Integer totalVisitors = (Integer) context.getAttribute("totalVisitors");
      
        String siteName = context.getInitParameter("siteName");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        
        out.println("<head>");
        out.println("<title>BookVerse - Welcome</title>");
        
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 40px; background-color: #f5f5f5; }");
        out.println(".container { max-width: 600px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
        out.println("h1 { color: #2c3e50; text-align: center; }");
        out.println(".stats { background: #ecf0f1; padding: 15px; border-radius: 5px; margin: 20px 0; }");
        out.println(".category-links { margin-top: 20px; }");
        out.println(".category-links a { display: block; padding: 10px; margin: 5px 0; background: #3498db; color: white; text-decoration: none; border-radius: 5px; text-align: center; }");
        out.println(".category-links a:hover { background: #2980b9; }");
        out.println("</style>");
        
        out.println("</head>");
        out.println("<body>");
        
        out.println("<div class='container'>");
        out.println("<h1>🔹 Welcome to BookVerse!</h1>");
        
        out.println("<div class='stats'>");
        out.println("<h3>📊 Site Statistics</h3>");
        out.println("<p><strong>Total Visitors So Far:</strong> " + totalVisitors + "</p>");
        out.println("<p><strong>System:</strong> " + siteName + "</p>");
        out.println("</div>");
        
        out.println("<div class='category-links'>");
        out.println("<h3>📚 Select a Category:</h3>");
        out.println("<a href='fiction'>1. Fiction</a>");
        out.println("<a href='science'>2. Science</a>");
        out.println("<a href='technology'>3. Technology</a>");
        out.println("<a href='admin'>🔧 Admin Panel</a>");
        out.println("</div>");
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
