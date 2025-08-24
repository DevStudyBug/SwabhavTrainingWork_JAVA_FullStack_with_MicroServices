package com.aurionpro.Voting;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
            String name = req.getParameter("name");
            String ageStr = req.getParameter("age");
            int age = 0;
            try {
                age = Integer.parseInt(ageStr);
            } catch (NumberFormatException e) {
                // Handle invalid number input
                res.setContentType("text/html");
                PrintWriter out = res.getWriter();
                out.println("<p style='color:red;'>Invalid age entered. Please enter a valid number.</p>");
                RequestDispatcher rd = req.getRequestDispatcher("index.html");
                rd.include(req, res);
                return;
            }

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();

            if (age >= 18  && age <= 60) {
                out.println("<h1>Welcome, " + name + "</h1>");
                out.println("<p>You are eligible to vote.</p>");
            
            } else {
                out.println("<h1>Sorry, " + name + "</h1>");
                out.println("<p>You are not eligible to vote. You must be in range of 18-60 years old.</p>");
            }
        }
    }