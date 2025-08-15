package com.aurionpro.model;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/answer")
public class AnswerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

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
            response.sendRedirect("login.html");
            return;
        }

        String answer = request.getParameter("answer");
        int qid = questionIds.get(currentIndex);

        // Store answer in session (key: answer_<questionId>)
        session.setAttribute("answer_" + qid, answer);

        // Increment current question index
        currentIndex++;
        session.setAttribute("currentQuestionIndex", currentIndex);

        if (currentIndex >= questionIds.size()) {
            response.sendRedirect("result");
        } else {
            response.sendRedirect("question");
        }
    }
}