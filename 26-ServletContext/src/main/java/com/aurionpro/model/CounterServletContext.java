package com.aurionpro.model;

import java.io.IOException;

import javax.naming.Context;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/visit")
public class CounterServletContext  extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	ServletContext context = getServletContext();
	Integer counter = (int)context.getAttribute("counter");
	counter ++;
	context.setAttribute("counter", counter);
	resp.setContentType("text/html");
	resp.getWriter().write("<h2>Visit Counter</h2>");
	resp.getWriter().write("<a href='/visit'>Visit Again</a>");
}
}
