package com.aurionpro.ECommerceCart;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ProductServlet extends HttpServlet {
    
    private String[] products = {"Laptop", "Phone", "Headphones", "Tablet", "Smartwatch"};
    private String[] prices = {"$999", "$699", "$199", "$399", "$299"};
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(10);
        
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.html");
            return;
        }
        
        String username = (String) session.getAttribute("username");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Product Selection</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; max-width: 600px; margin: 20px auto; }");
        out.println(".header { background: #f8f9fa; padding: 15px; border-radius: 8px; margin-bottom: 20px; }");
        out.println(".product { border: 1px solid #ddd; padding: 15px; margin: 10px 0; border-radius: 8px; }");
        out.println(".product input { margin-right: 10px; }");
        out.println(".buttons { margin: 20px 0; }");
        out.println("input[type='submit'] { background: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; margin-right: 10px; }");
        out.println("input[type='submit']:hover { background: #218838; }");
        out.println(".logout { background: #dc3545; }");
        out.println(".logout:hover { background: #c82333; }");
        out.println(".view-cart { background: #007bff; }");
        out.println(".view-cart:hover { background: #0056b3; }");
        out.println("</style>");
        out.println("</head><body>");
        
        out.println("<div class='header'>");
        out.println("<h2>🛍️ Welcome " + username + "!</h2>");
        out.println("</div>");
        
        out.println("<h3>Select Products:</h3>");
        out.println("<form action='CartServlet' method='post'>");
        
        for (int i = 0; i < products.length; i++) {
            out.println("<div class='product'>");
            out.println("<input type='checkbox' name='selectedProducts' value='" + products[i] + "'>");
            out.println("<strong>" + products[i] + "</strong> - " + prices[i]);
            out.println("</div>");
        }
        
        out.println("<div class='buttons'>");
        out.println("<input type='submit' value='Add to Cart'>");
        out.println("</form>");
        out.println("<form action='ViewCartServlet' method='get' style='display:inline;'>");
        out.println("<input type='submit' value='View Cart' class='view-cart'>");
        out.println("</form>");
        out.println("<form action='LogoutServlet' method='post' style='display:inline;'>");
        out.println("<input type='submit' value='Logout' class='logout'>");
        out.println("</form>");
        out.println("</div>");
        
        out.println("</body></html>");
    }
}
