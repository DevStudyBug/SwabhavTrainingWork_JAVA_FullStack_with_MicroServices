package com.aurionpro.ECommerceCart;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Get session and invalidate it
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            session.invalidate();
        }
        
        // Redirect to login page with logout message
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Logged Out</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; max-width: 400px; margin: 50px auto; text-align: center; }");
        out.println(".container { border: 1px solid #ddd; padding: 20px; border-radius: 8px; }");
        out.println(".success { color: #28a745; margin-bottom: 20px; }");
        out.println("a { background: #007bff; color: white; padding: 10px 20px; text-decoration: none; border-radius: 4px; }");
        out.println("a:hover { background: #0056b3; }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='container'>");
        out.println("<h2>✅ Logged Out Successfully!</h2>");
        out.println("<p class='success'>Thank you for shopping with us!</p>");
        out.println("<a href='index.html'>Login Again</a>");
        out.println("</div>");
        out.println("</body></html>");
    }
}
