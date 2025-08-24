package com.aurionpro.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve cookies from request
        Cookie[] cookies = request.getCookies();

        String name = null;

        // Check for cookie named "username"
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    name = cookie.getValue();
                    break;
                }
            }
        }

        // Display personalized message if username exists, else prompt to login
        if (name != null) {
            out.println("<h1>Welcome back, " + name + "!</h1>");
            out.println("<a href='logout'>Logout</a>");
        } else {
            out.println("<h1>No user found. Please <a href='login.html'>Login</a></h1>");
        }
    }
}