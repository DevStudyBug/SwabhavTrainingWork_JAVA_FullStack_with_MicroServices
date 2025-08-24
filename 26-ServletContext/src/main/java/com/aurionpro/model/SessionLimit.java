package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Session")
public class SessionLimit extends HttpServlet {


	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Create a session object if not already created
	        HttpSession session = request.getSession(true);
	        session.setMaxInactiveInterval(300); // 5 minutes = 300 seconds

	        // Get session creation and last access times
	        Date createTime = new Date(session.getCreationTime());
	        Date lastAccessTime = new Date(session.getLastAccessedTime());

	        String title = "Welcome to Servlet demo";
	        Integer visitCount = 0;
	        String visitCountKey = "visitCount";
	        String userIDKey = "userID";
	        String userID = "Admin";

	        // Check if it's a new session
	        if (session.isNew()) {
	            session.setAttribute(userIDKey, userID);
	        } else {
	            visitCount = (Integer) session.getAttribute(visitCountKey);
	            visitCount = visitCount + 1;
	            userID = (String) session.getAttribute(userIDKey);
	        }

	        session.setAttribute(visitCountKey, visitCount);

	        // Check if visit count exceeds 5
	        boolean shouldInvalidate = false;
	        if (visitCount > 5) {
	            shouldInvalidate = true;
	        }

	        // Set response content type
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        String docType = "<!DOCTYPE html>\n";

	        out.println(docType + "<html>\n"
	                + "<head><title>" + title + "</title></head>\n"
	                + "<body bgcolor=\"#f0f0f0\">\n"
	                + "<h1 align=\"center\">" + title + "</h1>\n");

	        if (shouldInvalidate) {
	            session.invalidate();
	            out.println("<h2 align=\"center\" style=\"color:red;\">Session invalidated after 5 visits!</h2>\n");
	        } else {
	            out.println("<h2 align=\"center\">Session Information</h2>\n"
	                    + "<table border=\"1\" align=\"center\">\n"
	                    + "<tr bgcolor=\"#949494\">\n"
	                    + "  <th>Session info</th><th>Value</th></tr>\n"
	                    + "<tr><td>Session ID</td><td>" + session.getId() + "</td></tr>\n"
	                    + "<tr><td>Creation Time</td><td>" + createTime + "</td></tr>\n"
	                    + "<tr><td>Last Access Time</td><td>" + lastAccessTime + "</td></tr>\n"
	                    + "<tr><td>User ID</td><td>" + userID + "</td></tr>\n"
	                    + "<tr><td>Number of Visits</td><td>" + visitCount + "</td></tr>\n"
	                    + "</table>\n");
	        }

	        out.println("</body></html>");
	    }
	}