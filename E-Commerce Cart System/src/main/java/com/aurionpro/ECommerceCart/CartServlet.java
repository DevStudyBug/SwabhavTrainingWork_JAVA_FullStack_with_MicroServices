package com.aurionpro.ECommerceCart;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CartServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        session.setMaxInactiveInterval(10);
        
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.html");
            return;
        }
        
        // Get selected products
        String[] selectedProducts = request.getParameterValues("selectedProducts");
        
        if (selectedProducts != null) {
            // Get existing cart from session
            List<String> cart = (List<String>) session.getAttribute("cart");
            
            // Add selected products to cart (avoid duplicates)
            for (String product : selectedProducts) {
                if (!cart.contains(product)) {
                    cart.add(product);
                }
            }
            
            // Update session
            session.setAttribute("cart", cart);
        }
        
        // Forward to ViewCartServlet using RequestDispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCartServlet");
        dispatcher.forward(request, response);
    }
}