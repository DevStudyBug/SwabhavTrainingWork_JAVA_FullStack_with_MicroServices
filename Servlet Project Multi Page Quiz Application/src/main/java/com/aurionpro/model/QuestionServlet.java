package com.aurionpro.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/question")
public class QuestionServlet extends HttpServlet {

    private static final int TOTAL_QUIZ_TIME = 300; // 5 minutes in seconds

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.html");
            return;
        }

        // Handle restart parameter
        if ("true".equals(request.getParameter("restart"))) {
            clearQuizSession(session);
            initializeNewQuiz(session, response);
            return;
        }

        List<Integer> questionIds = (List<Integer>) session.getAttribute("questionIds");
        Integer currentIndex = (Integer) session.getAttribute("currentQuestionIndex");
        Long quizStartTime = (Long) session.getAttribute("quizStartTime");

        // Initialize quiz if not already done
        if (questionIds == null || currentIndex == null) {
            initializeNewQuiz(session, response);
            return;
        }

        // Initialize timer if not set
        if (quizStartTime == null) {
            quizStartTime = System.currentTimeMillis();
            session.setAttribute("quizStartTime", quizStartTime);
        }

        // Check if quiz is complete
        if (currentIndex >= questionIds.size()) {
            response.sendRedirect("result");
            return;
        }

        // Calculate remaining time
        long elapsedMillis = System.currentTimeMillis() - quizStartTime;
        int elapsedSeconds = (int) (elapsedMillis / 1000);
        int remainingSeconds = TOTAL_QUIZ_TIME - elapsedSeconds;

        if (remainingSeconds <= 0) {
            response.sendRedirect("result");
            return;
        }

        // Display current question
        displayQuestion(request, response, session, questionIds, currentIndex, remainingSeconds);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.html");
            return;
        }

        List<Integer> questionIds = (List<Integer>) session.getAttribute("questionIds");
        Integer currentIndex = (Integer) session.getAttribute("currentQuestionIndex");

        if (questionIds == null || currentIndex == null) {
            response.sendRedirect("question?restart=true");
            return;
        }

        String qidStr = request.getParameter("qid");
        String answer = request.getParameter("answer");
        String action = request.getParameter("action");

        // Save answer if provided
        if (qidStr != null && answer != null) {
            session.setAttribute("answer_" + qidStr, answer);
        }

        // Handle navigation
        if ("Back".equals(action) && currentIndex > 0) {
            currentIndex--;
            session.setAttribute("currentQuestionIndex", currentIndex);
            response.sendRedirect("question");
        } else if ("Next".equals(action) || "Finish".equals(action)) {
            if (currentIndex < questionIds.size() - 1) {
                currentIndex++;
                session.setAttribute("currentQuestionIndex", currentIndex);
                response.sendRedirect("question");
            } else {
                response.sendRedirect("result");
            }
        } else {
            response.sendRedirect("question");
        }
    }

    private void clearQuizSession(HttpSession session) {
        session.removeAttribute("questionIds");
        session.removeAttribute("currentQuestionIndex");
        session.removeAttribute("quizStartTime");

        // Remove all answer attributes
        Enumeration<String> attrs = session.getAttributeNames();
        List<String> toRemove = new ArrayList<>();
        while (attrs.hasMoreElements()) {
            String attr = attrs.nextElement();
            if (attr.startsWith("answer_")) {
                toRemove.add(attr);
            }
        }
        for (String attr : toRemove) {
            session.removeAttribute(attr);
        }
    }

    private void initializeNewQuiz(HttpSession session, HttpServletResponse response) throws IOException {
        try (Connection con = DBConnection.getConnection()) {
            List<Integer> questionIds = new ArrayList<>();
            PreparedStatement pst = con.prepareStatement("SELECT id FROM questions ORDER BY RAND() LIMIT 5");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                questionIds.add(rs.getInt("id"));
            }
            rs.close();
            pst.close();

            session.setAttribute("questionIds", questionIds);
            session.setAttribute("currentQuestionIndex", 0);
            session.setAttribute("quizStartTime", System.currentTimeMillis());

            response.sendRedirect("question");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error initializing quiz: " + e.getMessage());
        }
    }

    private void displayQuestion(HttpServletRequest request, HttpServletResponse response, 
                               HttpSession session, List<Integer> questionIds, 
                               Integer currentIndex, int remainingSeconds) throws IOException {

        int qid = questionIds.get(currentIndex);

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM questions WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, qid);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                response.setContentType("text/html;charset=UTF-8");
                response.getWriter().println(generateQuestionHTML(rs, session, questionIds, currentIndex, qid, remainingSeconds));
            } else {
                response.sendRedirect("result");
            }
            rs.close();
            pst.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error loading question: " + e.getMessage());
        }
    }

    private String generateQuestionHTML(ResultSet rs, HttpSession session, List<Integer> questionIds, 
                                      int currentIndex, int qid, int remainingSeconds) throws Exception {
        
        StringBuilder html = new StringBuilder();
        
        html.append("<html><head><meta charset='UTF-8'><title>Quiz Question</title>");
        html.append("<style>");
        html.append("body {font-family: Arial, sans-serif; background-color: #f2f2f2; display: flex; justify-content: center; align-items: center; min-height: 100vh; margin:0; padding: 20px; box-sizing: border-box;}");
        html.append(".container {background-color: white; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.2); width: 100%; max-width: 500px;}");
        html.append("h2 {text-align: center; margin-bottom: 20px; color: #333;}");
        html.append("p {font-size: 18px; font-weight: bold; margin-bottom: 20px;}");
        html.append("label {display: block; margin: 15px 0; padding: 10px; border: 2px solid #e0e0e0; border-radius: 5px; cursor: pointer; transition: all 0.3s;}");
        html.append("label:hover {background-color: #f5f5f5; border-color: #4CAF50;}");
        html.append("input[type=radio] {margin-right: 10px;}");
        html.append("input[type=submit] {width: 48%; padding: 12px; background-color: #4CAF50; border: none; color: white; font-size: 16px; border-radius: 4px; margin-top: 20px; cursor: pointer;}");
        html.append("input[type=submit]:hover {background-color: #45a049;}");
        html.append("input[disabled] {background-color: #ccc; cursor: not-allowed;}");
        html.append(".timer {font-size: 24px; font-weight: bold; text-align: center; margin-bottom: 20px; color: #d9534f; padding: 10px; background: #fff3cd; border-radius: 5px;}");
        html.append(".button-container {display: flex; justify-content: space-between; margin-top: 20px;}");
        html.append("</style>");

        // Timer JavaScript
        html.append("<script>");
        html.append("let timeLeft = ").append(remainingSeconds).append(";");
        html.append("function startTimer() {");
        html.append("  const timerElem = document.getElementById('timer');");
        html.append("  const interval = setInterval(() => {");
        html.append("    if(timeLeft <= 0) {");
        html.append("      clearInterval(interval);");
        html.append("      alert('Time is up! Redirecting to results...');");
        html.append("      window.location.href = 'result';");
        html.append("    } else {");
        html.append("      let minutes = Math.floor(timeLeft / 60);");
        html.append("      let seconds = timeLeft % 60;");
        html.append("      timerElem.textContent = minutes.toString().padStart(2,'0') + ':' + seconds.toString().padStart(2,'0');");
        html.append("      timeLeft--;");
        html.append("    }");
        html.append("  }, 1000);");
        html.append("}");
        html.append("window.onload = startTimer;");
        html.append("</script>");

        html.append("</head><body>");
        html.append("<div class='container'>");

        // Timer display
        html.append("<div class='timer'>Time Left: <span id='timer'></span></div>");

        html.append("<h2>Question ").append(currentIndex + 1).append(" of ").append(questionIds.size()).append("</h2>");
        html.append("<form action='question' method='post'>");
        html.append("<input type='hidden' name='qid' value='").append(qid).append("'>");

        html.append("<p>").append(rs.getString("question_text")).append("</p>");

        // Get previously selected answer
        String savedAnswer = (String) session.getAttribute("answer_" + qid);

        // Display options
        String[] options = {"A", "B", "C", "D"};
        for (String opt : options) {
            String optionText = rs.getString("option_" + opt.toLowerCase());
            String checked = (opt.equals(savedAnswer)) ? "checked" : "";
            html.append("<label><input type='radio' name='answer' value='")
                .append(opt).append("' ").append(checked).append(" required> ")
                .append(optionText).append("</label>");
        }

        // Navigation buttons
        html.append("<div class='button-container'>");
        String backDisabled = (currentIndex == 0) ? "disabled" : "";
        String nextLabel = (currentIndex == questionIds.size() - 1) ? "Finish" : "Next";

        html.append("<input type='submit' name='action' value='Back' ").append(backDisabled).append(" />");
        html.append("<input type='submit' name='action' value='").append(nextLabel).append("' />");
        html.append("</div>");

        html.append("</form>");
        html.append("</div></body></html>");

        return html.toString();
    }
}