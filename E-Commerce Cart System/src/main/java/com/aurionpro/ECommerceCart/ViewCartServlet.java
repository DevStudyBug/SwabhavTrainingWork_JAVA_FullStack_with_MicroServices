package com.aurionpro.ECommerceCart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewCartServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Handle cart operations
        String action = request.getParameter("action");
        HttpSession session = request.getSession(false);
        
        if (session != null && action != null) {
            List<String> cart = (List<String>) session.getAttribute("cart");
            
            if ("remove".equals(action)) {
                String itemToRemove = request.getParameter("item");
                if (cart != null && itemToRemove != null) {
                    cart.remove(itemToRemove);
                }
            } else if ("clear".equals(action)) {
                if (cart != null) {
                    cart.clear();
                }
            }
            
            session.setAttribute("cart", cart);
        }
        
        processRequest(request, response);
    }
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("index.html");
            return;
        }
        
        String username = (String) session.getAttribute("username");
        List<String> cart = (List<String>) session.getAttribute("cart");
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<title>Shopping Cart</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; max-width: 600px; margin: 20px auto; }");
        out.println(".header { background: #f8f9fa; padding: 15px; border-radius: 8px; margin-bottom: 20px; }");
        out.println(".cart-item { border: 1px solid #ddd; padding: 10px; margin: 5px 0; border-radius: 4px; display: flex; justify-content: space-between; align-items: center; }");
        out.println(".empty-cart { text-align: center; color: #666; padding: 20px; }");
        out.println("input[type='submit'] { padding: 8px 15px; border: none; border-radius: 4px; cursor: pointer; margin-right: 10px; }");
        out.println(".remove-btn { background: #dc3545; color: white; }");
        out.println(".remove-btn:hover { background: #c82333; }");
        out.println(".clear-btn { background: #ffc107; color: black; }");
        out.println(".clear-btn:hover { background: #e0a800; }");
        out.println(".continue-btn { background: #28a745; color: white; }");
        out.println(".continue-btn:hover { background: #218838; }");
        out.println(".logout-btn { background: #dc3545; color: white; }");
        out.println(".logout-btn:hover { background: #c82333; }");
        out.println(".buttons { margin: 20px 0; }");
        out.println("</style>");
        out.println("</head><body>");
        
        out.println("<div class='header'>");
        out.println("<h2>🛒 " + username + "'s Shopping Cart</h2>");
        out.println("</div>");
        
        if (cart == null || cart.isEmpty()) {
            out.println("<div class='empty-cart'>");
            out.println("<h3>Your cart is empty!</h3>");
            out.println("<p>Go back to products to add items.</p>");
            out.println("</div>");
        } else {
            out.println("<h3>Cart Items:</h3>");
            
            for (String item : cart) {
                out.println("<div class='cart-item'>");
                out.println("<span>📦 " + item + "</span>");
                out.println("<form method='post' style='display:inline;'>");
                out.println("<input type='hidden' name='action' value='remove'>");
                out.println("<input type='hidden' name='item' value='" + item + "'>");
                out.println("<input type='submit' value='Remove' class='remove-btn'>");
                out.println("</form>");
                out.println("</div>");
            }
            
            out.println("<div class='buttons'>");
            out.println("<form method='post' style='display:inline;'>");
            out.println("<input type='hidden' name='action' value='clear'>");
            out.println("<input type='submit' value='Clear All' class='clear-btn'>");
            out.println("</form>");
            out.println("</div>");
        }
        
        out.println("<div class='buttons'>");
        out.println("<form action='ProductServlet' method='get' style='display:inline;'>");
        out.println("<input type='submit' value='Continue Shopping' class='continue-btn'>");
        out.println("</form>");
        out.println("<form action='LogoutServlet' method='post' style='display:inline;'>");
        out.println("<input type='submit' value='Logout' class='logout-btn'>");
        out.println("</form>");
        out.println("</div>");
        
        out.println("</body></html>");
    }
}
