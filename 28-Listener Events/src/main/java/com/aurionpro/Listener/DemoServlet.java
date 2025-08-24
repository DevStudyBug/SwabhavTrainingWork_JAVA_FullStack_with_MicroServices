package com.aurionpro.Listener;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the 'name' parameter from the form
        String name = request.getParameter("name");

        // Create or retrieve the current session
        HttpSession session = request.getSession();

        // Store the name in session attribute
        session.setAttribute("name", name);

        // Set response content type
        response.setContentType("text/html");

        // Generate HTML response with welcome message and "Go Back" button
        response.getWriter().println("<html>");
        response.getWriter().println("<head><title>Welcome</title></head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<h2>Welcome " + name + "</h2>");
        response.getWriter().println("<p>Your session ID: " + session.getId() + "</p>");
        response.getWriter().println("<form action='login.html' method='get'>");
        response.getWriter().println("<input type='submit' value='Go Back to Login' />");
        response.getWriter().println("</form>");
        response.getWriter().println("</body>");
        response.getWriter().println("</html>");
    }
}