package com.aurionpro.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Check for valid session
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("userId") == null) {
            response.sendRedirect("login.html");
            return;
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String currentUsername = (String) session.getAttribute("username");
        int currentUserScore = 0;

        try (Connection conn = DBConnection.getConnection()) {
            // Get current user's best score
            String userScoreSql = "SELECT MAX(score) as best_score FROM results WHERE user_id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(userScoreSql)) {
                stmt.setInt(1, (Integer) session.getAttribute("userId"));
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        currentUserScore = rs.getInt("best_score");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            currentUserScore = 0;
        }

        // Generate enhanced HTML with modern CSS
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Quiz Dashboard</title>");
        out.println("<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css' rel='stylesheet'>");
        
        // Enhanced CSS with modern design
        out.println("<style>");
        out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
        out.println("body { ");
        out.println("  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        out.println("  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);");
        out.println("  min-height: 100vh;");
        out.println("  padding: 20px;");
        out.println("  color: #333;");
        out.println("  display: flex;");
        out.println("  align-items: center;");
        out.println("  justify-content: center;");
        out.println("}");
        
        out.println(".dashboard-container {");
        out.println("  max-width: 600px;");
        out.println("  width: 100%;");
        out.println("  animation: fadeInUp 0.8s ease-out;");
        out.println("}");
        
        out.println(".header {");
        out.println("  text-align: center;");
        out.println("  margin-bottom: 40px;");
        out.println("  color: white;");
        out.println("}");
        
        out.println(".header h1 {");
        out.println("  font-size: 3rem;");
        out.println("  margin-bottom: 10px;");
        out.println("  text-shadow: 2px 2px 4px rgba(0,0,0,0.3);");
        out.println("}");
        
        out.println(".header p {");
        out.println("  font-size: 1.2rem;");
        out.println("  opacity: 0.9;");
        out.println("}");
        
        out.println(".score-card {");
        out.println("  background: rgba(255, 255, 255, 0.95);");
        out.println("  padding: 30px;");
        out.println("  border-radius: 20px;");
        out.println("  box-shadow: 0 10px 30px rgba(0,0,0,0.2);");
        out.println("  text-align: center;");
        out.println("  margin-bottom: 40px;");
        out.println("  position: relative;");
        out.println("  overflow: hidden;");
        out.println("}");
        
        out.println(".score-card::before {");
        out.println("  content: '';");
        out.println("  position: absolute;");
        out.println("  top: 0;");
        out.println("  left: 0;");
        out.println("  right: 0;");
        out.println("  height: 4px;");
        out.println("  background: linear-gradient(90deg, #4CAF50, #2196F3, #FF9800);");
        out.println("}");
        
        out.println(".score-icon {");
        out.println("  font-size: 3rem;");
        out.println("  margin-bottom: 15px;");
        out.println("  color: #667eea;");
        out.println("}");
        
        out.println(".score-value {");
        out.println("  font-size: 3rem;");
        out.println("  font-weight: bold;");
        out.println("  color: #2c3e50;");
        out.println("  margin-bottom: 10px;");
        out.println("}");
        
        out.println(".score-label {");
        out.println("  font-size: 1.2rem;");
        out.println("  color: #7f8c8d;");
        out.println("  text-transform: uppercase;");
        out.println("  letter-spacing: 1px;");
        out.println("}");
        
        out.println(".action-buttons {");
        out.println("  display: flex;");
        out.println("  justify-content: center;");
        out.println("  gap: 20px;");
        out.println("  flex-wrap: wrap;");
        out.println("}");
        
        out.println(".btn {");
        out.println("  display: inline-flex;");
        out.println("  align-items: center;");
        out.println("  gap: 10px;");
        out.println("  padding: 15px 30px;");
        out.println("  text-decoration: none;");
        out.println("  border-radius: 50px;");
        out.println("  font-size: 1.1rem;");
        out.println("  font-weight: 600;");
        out.println("  transition: all 0.3s ease;");
        out.println("  text-transform: uppercase;");
        out.println("  letter-spacing: 1px;");
        out.println("  box-shadow: 0 5px 15px rgba(0,0,0,0.2);");
        out.println("}");
        
        out.println(".btn:hover {");
        out.println("  transform: translateY(-3px);");
        out.println("  box-shadow: 0 8px 25px rgba(0,0,0,0.3);");
        out.println("}");
        
        out.println(".btn-primary {");
        out.println("  background: linear-gradient(45deg, #4CAF50, #45a049);");
        out.println("  color: white;");
        out.println("}");
        
        out.println(".btn-danger {");
        out.println("  background: linear-gradient(45deg, #f44336, #d32f2f);");
        out.println("  color: white;");
        out.println("}");
        
        out.println(".welcome-message {");
        out.println("  background: rgba(255, 255, 255, 0.9);");
        out.println("  padding: 20px;");
        out.println("  border-radius: 15px;");
        out.println("  text-align: center;");
        out.println("  margin-bottom: 30px;");
        out.println("  box-shadow: 0 5px 15px rgba(0,0,0,0.1);");
        out.println("}");
        
        out.println("@keyframes fadeInUp {");
        out.println("  from {");
        out.println("    opacity: 0;");
        out.println("    transform: translateY(30px);");
        out.println("  }");
        out.println("  to {");
        out.println("    opacity: 1;");
        out.println("    transform: translateY(0);");
        out.println("  }");
        out.println("}");
        
        out.println("@media (max-width: 768px) {");
        out.println("  .header h1 { font-size: 2rem; }");
        out.println("  .action-buttons { flex-direction: column; align-items: center; }");
        out.println("  .btn { width: 200px; justify-content: center; }");
        out.println("  .dashboard-container { padding: 10px; }");
        out.println("}");
        
        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='dashboard-container'>");
        
        // Header
        out.println("<div class='header'>");
        out.println("<h1><i class='fas fa-trophy'></i> Quiz Dashboard</h1>");
        out.println("<p>Ready to test your knowledge?</p>");
        out.println("</div>");

        // Welcome message
        if (currentUsername != null) {
            out.println("<div class='welcome-message'>");
            out.println("<h2><i class='fas fa-user-circle'></i> Welcome back, " + currentUsername + "!</h2>");
            out.println("</div>");
        }

        // Your Best Score Card
        out.println("<div class='score-card'>");
        out.println("<div class='score-icon'><i class='fas fa-chart-line'></i></div>");
        out.println("<div class='score-value'>" + currentUserScore + "</div>");
        out.println("<div class='score-label'>Your Best Score</div>");
        out.println("</div>");

        // Action buttons - only Start Quiz and Logout
        out.println("<div class='action-buttons'>");
        out.println("<a href='question?restart=true' class='btn btn-primary'>");
        out.println("<i class='fas fa-play'></i> Start Quiz");
        out.println("</a>");
        out.println("<a href='logout' class='btn btn-danger'>");
        out.println("<i class='fas fa-sign-out-alt'></i> Logout");
        out.println("</a>");
        out.println("</div>");

        out.println("</div>");
        out.println("</body></html>");
    }
}