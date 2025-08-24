package com.aurionpro.ServletRequestDispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String user = req.getParameter("username");
        String pass = req.getParameter("password");

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        if ("admin".equals(user) && "1234".equals(pass)) {
            // Forward to WelcomeServlet
            RequestDispatcher rd = req.getRequestDispatcher("welcome");
            rd.forward(req, res);
        } else {
            out.println("<p style='color:red;'>Invalid username or password. Please try again.</p>");
            RequestDispatcher rd = req.getRequestDispatcher("login.html");
            rd.include(req, res);
        }
    }
}
