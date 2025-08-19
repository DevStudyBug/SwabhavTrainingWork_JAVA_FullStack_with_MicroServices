package com.aurionpro.test;

import java.io.IOException;

import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/abc")
public class withoutWebXML extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.write("<h1>Servlet without web XML!!</h1>");
	}
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	System.out.println("This is my 1st service method servlet."); // Printed on server console

	arg1.setContentType("text/html"); 
	PrintWriter pw = arg1.getWriter();
	pw.write("This is my service method "); // Displayed in browser

	
	
}	
}
