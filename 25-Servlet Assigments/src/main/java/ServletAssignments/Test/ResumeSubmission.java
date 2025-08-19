package ServletAssignments.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/resumeUpload")
public class ResumeSubmission extends HttpServlet {
   

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String resume = request.getParameter("resume");
        String skillsInput = request.getParameter("skills");

        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        pw.println("<html><body><h2>Resume Submission Result</h2>");

        boolean hasError = false;

        // Name validation
        if (name == null || name.trim().length() < 2) {
            pw.println("<p style='color:red;'>Name must be at least 2 characters.</p>");
            hasError = true;
        }

        // Email validation
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            pw.println("<p style='color:red;'>Invalid email format.</p>");
            hasError = true;
        }

        // Skills validation
        if (skillsInput == null || skillsInput.trim().isEmpty()) {
            pw.println("<p style='color:red;'>Please enter at least one skill.</p>");
            hasError = true;
        }

        if (!hasError) {
            // Resume Preview
            pw.println("<h3>Resume Preview:</h3>");
            pw.println("<p><strong>Name:</strong> " + name + "</p>");
            pw.println("<p><strong>Email:</strong> " + email + "</p>");

            if (resume != null && !resume.trim().isEmpty()) {
                pw.println("<p><strong>Resume:</strong><br><pre>" + resume + "</pre></p>");
            } else {
                pw.println("<p><strong>Resume:</strong> Not submitted.</p>");
            }

            pw.println("<p><strong>Skills:</strong></p><ul>");
            String[] skills = skillsInput.split(",");
            for (String skill : skills) {
                pw.println("<li>" + skill.trim() + "</li>");
            }
            pw.println("</ul>");
        }
        pw.println("<br><a href='ResumeSubmission.html'>Back to Resume form</a>");

        pw.println("</body></html>");
        pw.close();
    }
}