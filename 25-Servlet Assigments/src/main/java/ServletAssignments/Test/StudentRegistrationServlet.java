package ServletAssignments.Test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class StudentRegistrationServlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String ageStr = req.getParameter("age");
	String course = req.getParameter("course");
	
	resp.setContentType("text/html");
	PrintWriter pw = resp.getWriter();
	pw.write("<h2>Student registration result!</h2>");
	
	boolean hasError = false;
	if (name == null || name.isEmpty()) {
		pw.println("name is required!");
		hasError = true;
	}
	if (email==null || email.isEmpty()) {
		pw.println("Email is required.");
	}

	int age = 0;
    try {
        age = Integer.parseInt(ageStr);
        if (age < 18 || age >30) {
            pw.println("Age must be 18 or less then 30");
            hasError = true;
        }
    } catch (NumberFormatException e) {
        pw.println("Please enter a valid age.");
        hasError = true;
    }
    if (course==null || course.isEmpty()) {
		pw.println("course selection is required.");
	}
    
    if(!hasError) {
    	pw.println("<h4>Registration successful</h4>");
    }
    pw.println("<br><a href='StudentRegistration.html'>Back to Student registration form</a>");
    pw.close();
}
}

//
//1. Domain: Education - Student Registration Form
//Servlet Name: StudentRegistrationServlet
//Problem Statement:
//Create a form that collects student information like name, email, age, and selected course. On
//submission (using POST), the servlet should validate the inputs:
// Name and email must not be empty.
// Age should be ≥ 18.
// Course must be selected.
//Display either a success message with submitted info or appropriate validation errors