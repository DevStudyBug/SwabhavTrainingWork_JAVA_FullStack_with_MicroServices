package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ReviewServlet.class.getName());

    @SuppressWarnings("unchecked")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Integer> questionIds = (List<Integer>) session.getAttribute("questionIds");
        if (questionIds == null || questionIds.isEmpty()) {
            response.sendRedirect("dashboard");
            return;
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String username = (String) session.getAttribute("username");

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) {
                LOGGER.log(Level.SEVERE, "Database connection is null");
                generateErrorHTML(out, "Database connection failed");
                return;
            }

            generateReviewHTML(out, con, questionIds, username);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error generating review for user: " + username, e);
            generateErrorHTML(out, "Error loading review: " + e.getMessage());
        }
    }

    private void generateReviewHTML(PrintWriter out, Connection con, List<Integer> questionIds, 
                                  String username) throws Exception {
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Quiz Review</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f5f5f5; }");
        out.println(".container { max-width: 800px; margin: 0 auto; background: white; padding: 20px; border-radius: 8px; }");
        out.println(".header { text-align: center; margin-bottom: 30px; color: #333; }");
        out.println(".question { margin-bottom: 25px; padding: 15px; border: 1px solid #ddd; border-radius: 5px; }");
        out.println(".question-text { font-weight: bold; margin-bottom: 15px; font-size: 16px; }");
        out.println(".options { margin-bottom: 15px; }");
        out.println(".option { margin: 5px 0; padding: 8px; background: #f9f9f9; border-radius: 3px; }");
        out.println(".correct-answer { background-color: #d4edda; color: #155724; padding: 10px; border-radius: 3px; font-weight: bold; }");
        out.println(".nav-buttons { text-align: center; margin-top: 30px; }");
        out.println(".btn { display: inline-block; padding: 10px 20px; margin: 5px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; }");
        out.println(".btn:hover { background: #0056b3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<div class='container'>");

        // Header
        out.println("<div class='header'>");
        out.println("<h1>Quiz Review</h1>");
        if (username != null) {
            out.println("<p>Welcome, " + escapeHtml(username) + "!</p>");
        }
        out.println("</div>");

        // Questions
        String sql = "SELECT id, question_text, option_a, option_b, option_c, option_d, correct_option FROM questions WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);

        int questionNumber = 1;

        for (Integer qid : questionIds) {
            pst.setInt(1, qid);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String questionText = rs.getString("question_text");
                    String optionA = rs.getString("option_a");
                    String optionB = rs.getString("option_b");
                    String optionC = rs.getString("option_c");
                    String optionD = rs.getString("option_d");
                    String correctAnswer = rs.getString("correct_option");

                    out.println("<div class='question'>");
                    
                    // Question number and text
                    out.println("<div class='question-text'>");
                    out.println("Question " + questionNumber + ": " + escapeHtml(questionText));
                    out.println("</div>");

                    // Options
                    out.println("<div class='options'>");
                    out.println("<div class='option'>A. " + escapeHtml(optionA) + "</div>");
                    out.println("<div class='option'>B. " + escapeHtml(optionB) + "</div>");
                    out.println("<div class='option'>C. " + escapeHtml(optionC) + "</div>");
                    out.println("<div class='option'>D. " + escapeHtml(optionD) + "</div>");
                    out.println("</div>");

                    // Correct answer
                    out.println("<div class='correct-answer'>");
                    out.println("Correct Answer: " + correctAnswer.toUpperCase() + " - " + 
                              getOptionText(correctAnswer, optionA, optionB, optionC, optionD));
                    out.println("</div>");

                    out.println("</div>");
                    questionNumber++;
                }
            }
        }

        // Navigation buttons
        out.println("<div class='nav-buttons'>");
        out.println("<a href='question?restart=true' class='btn'>Take Another Quiz</a>");
        out.println("<a href='dashboard' class='btn'>Dashboard</a>");
        out.println("<a href='logout' class='btn'>Logout</a>");
        out.println("</div>");

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

        pst.close();
    }

    private String getOptionText(String optionLetter, String optionA, String optionB, String optionC, String optionD) {
        if (optionLetter == null) return "";
        
        switch (optionLetter.toUpperCase()) {
            case "A": return escapeHtml(optionA);
            case "B": return escapeHtml(optionB);
            case "C": return escapeHtml(optionC);
            case "D": return escapeHtml(optionD);
            default: return "";
        }
    }

    private String escapeHtml(String input) {
        if (input == null) return "";
        return input.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#39;");
    }

    private void generateErrorHTML(PrintWriter out, String errorMessage) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Error</title></head>");
        out.println("<body>");
        out.println("<div style='text-align: center; margin-top: 50px;'>");
        out.println("<h2>Error</h2>");
        out.println("<p>" + escapeHtml(errorMessage) + "</p>");
        out.println("<a href='dashboard'>Go to Dashboard</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}