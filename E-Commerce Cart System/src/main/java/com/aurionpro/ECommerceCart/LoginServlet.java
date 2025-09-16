package com.aurionpro.ECommerceCart;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        
        if (username != null && !username.trim().isEmpty()) {
            // Create session and store username
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("cart", new java.util.ArrayList<String>());
            
            // Redirect to ProductServlet
            response.sendRedirect("ProductServlet");
        } else {
            // Invalid login - back to login page
            response.sendRedirect("index.html");
        }
    }
}