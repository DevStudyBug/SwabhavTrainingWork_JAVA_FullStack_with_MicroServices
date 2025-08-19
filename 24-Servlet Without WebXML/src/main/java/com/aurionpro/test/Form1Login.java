package com.aurionpro.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/anshika")
public class Form1Login extends HttpServlet {
	
	@Override
	
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	    String name = req.getParameter("username");
//	    PrintWriter pw = resp.getWriter();
//	    pw.write("Welcome " + name);
//	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException{
	 resp.sendRedirect("Form2.html");
}
}