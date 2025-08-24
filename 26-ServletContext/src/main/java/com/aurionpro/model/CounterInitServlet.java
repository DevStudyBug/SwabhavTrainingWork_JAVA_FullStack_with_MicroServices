package com.aurionpro.model;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet ("/initCounter")
public class CounterInitServlet extends HttpServlet{

@Override
public void init() throws ServletException {
ServletContext context = getServletContext();
context.setAttribute("counter", 0);
System.out.println("Counter is initialize with 0");

}

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Counter initialize visit , now u can go to -->  /visit");
		resp.getWriter().write("<p><a href='/visit'>Click here to visit </a></p>");
	}
}
