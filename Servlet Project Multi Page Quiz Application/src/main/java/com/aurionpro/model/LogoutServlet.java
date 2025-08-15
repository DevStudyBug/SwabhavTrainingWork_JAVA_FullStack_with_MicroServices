package com.aurionpro.model;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LogoutServlet.class.getName());

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        String username = null;
        
        if (session != null) {
            username = (String) session.getAttribute("username");
            // Clear all quiz-related session data
            session.removeAttribute("userId");
            session.removeAttribute("username");
            session.removeAttribute("questionIds");
            session.removeAttribute("currentQuestionIndex");
            session.removeAttribute("score");
            
            // Remove any answer attributes
            java.util.Enumeration<String> attributeNames = session.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String attributeName = attributeNames.nextElement();
                if (attributeName.startsWith("answer_")) {
                    session.removeAttribute(attributeName);
                }
            }
            
            // Invalidate session
            session.invalidate();
            LOGGER.info("User logged out successfully: " + (username != null ? username : "unknown"));
        }

        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(generateLogoutHTML());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Generates styled HTML logout response
     */
    private String generateLogoutHTML() {
        return "<!DOCTYPE html>" +
               "<html><head>" +
               "<title>Logged Out</title>" +
               "<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css' rel='stylesheet'>" +
               "<style>" +
               "body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); margin: 0; padding: 20px; min-height: 100vh; display: flex; align-items: center; justify-content: center; }" +
               ".logout-container { background: rgba(255, 255, 255, 0.95); padding: 50px; border-radius: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.2); text-align: center; max-width: 500px; animation: slideIn 0.8s ease-out; }" +
               ".icon { font-size: 5rem; color: #4CAF50; margin-bottom: 20px; animation: bounce 2s infinite; }" +
               ".title { font-size: 2rem; margin-bottom: 15px; color: #2c3e50; font-weight: 600; }" +
               ".message { font-size: 1.1rem; margin-bottom: 30px; color: #666; line-height: 1.5; }" +
               ".redirect-info { color: #888; font-size: 0.9rem; margin-bottom: 30px; }" +
               ".btn { display: inline-flex; align-items: center; gap: 10px; padding: 15px 30px; background: linear-gradient(45deg, #2196F3, #1976D2); color: white; text-decoration: none; border-radius: 50px; font-weight: 600; transition: all 0.3s ease; text-transform: uppercase; letter-spacing: 1px; }" +
               ".btn:hover { transform: translateY(-3px); box-shadow: 0 8px 25px rgba(33, 150, 243, 0.4); }" +
               "@keyframes slideIn { from { opacity: 0; transform: translateY(-50px); } to { opacity: 1; transform: translateY(0); } }" +
               "@keyframes bounce { 0%, 20%, 50%, 80%, 100% { transform: translateY(0); } 40% { transform: translateY(-10px); } 60% { transform: translateY(-5px); } }" +
               "</style>" +
               "</head><body>" +
               "<div class='logout-container'>" +
               "<div class='icon'><i class='fas fa-check-circle'></i></div>" +
               "<div class='title'>Successfully Logged Out</div>" +
               "<div class='message'>Thank you for using our quiz application!<br>Your session has been safely terminated.</div>" +
               "<div class='redirect-info'>You will be redirected to login page in 5 seconds...</div>" +
               "<a href='login.html' class='btn'><i class='fas fa-sign-in-alt'></i> Login Again</a>" +
               "</div>" +
               "<script>setTimeout(function(){ window.location='login.html'; }, 5000);</script>" +
               "</body></html>";
    }
}