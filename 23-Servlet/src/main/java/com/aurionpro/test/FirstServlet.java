package com.aurionpro.test;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.connector.Response;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet  {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	System.out.println("This is my first servlet! ");
	PrintWriter pw = resp.getWriter();
	pw.write("<h1>This is my first servlet</h1>"
			+ "<br>");
	
	resp.getWriter().println("Without print writter object!!");
}
}
