package com.aurionpro.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	
	 // Get all cookies
    Cookie[] cookies = req.getCookies();

    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                // Delete the cookie
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
                break;
            }
        }
    }

    pw.println("<h1>You are logged out successfully!</h1>");
    pw.println("<a href='login.html'>Login Again</a>");
}
}