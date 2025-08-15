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

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(ResultServlet.class.getName());

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
            response.sendRedirect("question?restart=true");
            return;
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        int score = 0;
        int total = questionIds.size();
        String username = (String) session.getAttribute("username");
        Integer userId = (Integer) session.getAttribute("userId");

        try (Connection con = DBConnection.getConnection()) {
            if (con == null) {
                LOGGER.log(Level.SEVERE, "Database connection is null");
                generateErrorHTML(out, "Database connection failed");
                return;
            }

            String sql = "SELECT correct_option FROM questions WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            // Calculate score
            for (Integer qid : questionIds) {
                pst.setInt(1, qid);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String correctAnswer = rs.getString("correct_option");
                        String userAnswer = (String) session.getAttribute("answer_" + qid);
                        
                        LOGGER.info("Question " + qid + " - Correct: " + correctAnswer + ", User: " + userAnswer);
                        
                        if (correctAnswer != null && userAnswer != null && 
                            correctAnswer.trim().equalsIgnoreCase(userAnswer.trim())) {
                            score++;
                        }
                    }
                } catch (Exception e) {
                    LOGGER.log(Level.WARNING, "Error processing question " + qid, e);
                }
            }
            pst.close();

            // Save result in database
            String insertSql = "INSERT INTO results (user_id, score) VALUES (?, ?)";
            try (PreparedStatement insertStmt = con.prepareStatement(insertSql)) {
                insertStmt.setInt(1, userId);
                insertStmt.setInt(2, score);
                int rowsInserted = insertStmt.executeUpdate();
                
                if (rowsInserted > 0) {
                    LOGGER.info("Quiz result saved for user: " + username + ", Score: " + score + "/" + total);
                } else {
                    LOGGER.warning("Failed to insert quiz result");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error saving quiz result", e);
                // Continue even if saving fails
            }

            // Get user's best score
            int bestScore = score;
            String bestScoreSql = "SELECT MAX(score) as best_score FROM results WHERE user_id = ?";
            try (PreparedStatement bestStmt = con.prepareStatement(bestScoreSql)) {
                bestStmt.setInt(1, userId);
                try (ResultSet rs = bestStmt.executeQuery()) {
                    if (rs.next()) {
                        int dbBestScore = rs.getInt("best_score");
                        bestScore = Math.max(bestScore, dbBestScore);
                    }
                }
            } catch (Exception e) {
                LOGGER.log(Level.WARNING, "Error getting best score", e);
            }

            // Prepare session for another quiz
            session.setAttribute("currentQuestionIndex", 0);
            for (Integer qid : questionIds) {
                session.removeAttribute("answer_" + qid);
            }

            // Generate HTML response
            generateResultHTML(out, score, total, username, bestScore);

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error calculating quiz result for user: " + username, e);
            generateErrorHTML(out, "Error calculating results: " + e.getMessage());
        }
    }

    private void generateResultHTML(PrintWriter out, int score, int total, String username, int bestScore) {
        int percentage = total > 0 ? (score * 100) / total : 0;
        String performanceLevel = getPerformanceLevel(percentage);
        String performanceColor = getPerformanceColor(percentage);
        String performanceIcon = getPerformanceIcon(percentage);

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Quiz Results</title>");
        out.println("<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css' rel='stylesheet'>");

        // Enhanced CSS with animations and modern design
        out.println("<style>");
        out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
        
        out.println("body {");
        out.println("  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        out.println("  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);");
        out.println("  min-height: 100vh;");
        out.println("  padding: 20px;");
        out.println("  display: flex;");
        out.println("  align-items: center;");
        out.println("  justify-content: center;");
        out.println("}");

        out.println(".result-container {");
        out.println("  background: rgba(255, 255, 255, 0.95);");
        out.println("  padding: 40px;");
        out.println("  border-radius: 25px;");
        out.println("  box-shadow: 0 20px 40px rgba(0,0,0,0.2);");
        out.println("  text-align: center;");
        out.println("  max-width: 600px;");
        out.println("  width: 100%;");
        out.println("  animation: resultSlideIn 1s ease-out;");
        out.println("  position: relative;");
        out.println("  overflow: hidden;");
        out.println("}");

        out.println(".result-container::before {");
        out.println("  content: '';");
        out.println("  position: absolute;");
        out.println("  top: 0;");
        out.println("  left: 0;");
        out.println("  right: 0;");
        out.println("  height: 5px;");
        out.println("  background: linear-gradient(90deg, #4CAF50, #2196F3, #FF9800);");
        out.println("}");

        out.println(".performance-icon {");
        out.println("  font-size: 4rem;");
        out.println("  color: " + performanceColor + ";");
        out.println("  margin-bottom: 15px;");
        out.println("  animation: bounce 2s infinite;");
        out.println("}");

        out.println(".congratulations {");
        out.println("  font-size: 1.8rem;");
        out.println("  color: #2c3e50;");
        out.println("  font-weight: 600;");
        out.println("  margin-bottom: 10px;");
        out.println("}");

        out.println(".username {");
        out.println("  color: #667eea;");
        out.println("  font-size: 1.3rem;");
        out.println("  margin-bottom: 20px;");
        out.println("}");

        out.println(".score-section {");
        out.println("  margin: 30px 0;");
        out.println("  padding: 25px;");
        out.println("  background: linear-gradient(135deg, #f8f9ff 0%, #e8ecff 100%);");
        out.println("  border-radius: 15px;");
        out.println("}");

        out.println(".main-score {");
        out.println("  font-size: 3.5rem;");
        out.println("  font-weight: bold;");
        out.println("  color: " + performanceColor + ";");
        out.println("  margin-bottom: 10px;");
        out.println("  animation: scoreCountUp 2s ease-out;");
        out.println("}");

        out.println(".score-details {");
        out.println("  font-size: 1.2rem;");
        out.println("  color: #666;");
        out.println("  margin-bottom: 15px;");
        out.println("}");

        out.println(".performance-level {");
        out.println("  display: inline-block;");
        out.println("  padding: 8px 20px;");
        out.println("  background: " + performanceColor + ";");
        out.println("  color: white;");
        out.println("  border-radius: 25px;");
        out.println("  font-weight: 600;");
        out.println("  font-size: 1rem;");
        out.println("  text-transform: uppercase;");
        out.println("  letter-spacing: 1px;");
        out.println("}");

        out.println(".stats-grid {");
        out.println("  display: grid;");
        out.println("  grid-template-columns: repeat(auto-fit, minmax(120px, 1fr));");
        out.println("  gap: 20px;");
        out.println("  margin: 30px 0;");
        out.println("}");

        out.println(".stat-item {");
        out.println("  padding: 15px;");
        out.println("  background: rgba(255, 255, 255, 0.7);");
        out.println("  border-radius: 10px;");
        out.println("  border: 2px solid #e9ecef;");
        out.println("}");

        out.println(".stat-value {");
        out.println("  font-size: 1.8rem;");
        out.println("  font-weight: bold;");
        out.println("  color: #2c3e50;");
        out.println("  margin-bottom: 5px;");
        out.println("}");

        out.println(".stat-label {");
        out.println("  font-size: 0.8rem;");
        out.println("  color: #7f8c8d;");
        out.println("  text-transform: uppercase;");
        out.println("  letter-spacing: 1px;");
        out.println("}");

        out.println(".action-buttons {");
        out.println("  display: flex;");
        out.println("  justify-content: center;");
        out.println("  gap: 15px;");
        out.println("  flex-wrap: wrap;");
        out.println("  margin-top: 30px;");
        out.println("}");

        out.println(".btn {");
        out.println("  display: inline-flex;");
        out.println("  align-items: center;");
        out.println("  gap: 8px;");
        out.println("  padding: 12px 25px;");
        out.println("  text-decoration: none;");
        out.println("  border-radius: 50px;");
        out.println("  font-size: 0.95rem;");
        out.println("  font-weight: 600;");
        out.println("  transition: all 0.3s ease;");
        out.println("  text-transform: uppercase;");
        out.println("  letter-spacing: 1px;");
        out.println("  box-shadow: 0 4px 15px rgba(0,0,0,0.1);");
        out.println("  border: none;");
        out.println("  cursor: pointer;");
        out.println("}");

        out.println(".btn:hover {");
        out.println("  transform: translateY(-3px);");
        out.println("  box-shadow: 0 8px 25px rgba(0,0,0,0.2);");
        out.println("}");

        out.println(".btn-primary { background: linear-gradient(45deg, #4CAF50, #45a049); color: white; }");
        out.println(".btn-info { background: linear-gradient(45deg, #2196F3, #1976D2); color: white; }");
        out.println(".btn-warning { background: linear-gradient(45deg, #FF9800, #F57C00); color: white; }");
        out.println(".btn-danger { background: linear-gradient(45deg, #f44336, #d32f2f); color: white; }");

        // Animations
        out.println("@keyframes resultSlideIn {");
        out.println("  from { opacity: 0; transform: translateY(-50px) scale(0.9); }");
        out.println("  to { opacity: 1; transform: translateY(0) scale(1); }");
        out.println("}");

        out.println("@keyframes bounce {");
        out.println("  0%, 20%, 50%, 80%, 100% { transform: translateY(0); }");
        out.println("  40% { transform: translateY(-10px); }");
        out.println("  60% { transform: translateY(-5px); }");
        out.println("}");

        out.println("@keyframes scoreCountUp {");
        out.println("  from { transform: scale(0.5); opacity: 0; }");
        out.println("  50% { transform: scale(1.2); }");
        out.println("  to { transform: scale(1); opacity: 1; }");
        out.println("}");

        // Responsive design
        out.println("@media (max-width: 768px) {");
        out.println("  .result-container { padding: 25px; margin: 10px; }");
        out.println("  .congratulations { font-size: 1.4rem; }");
        out.println("  .main-score { font-size: 2.5rem; }");
        out.println("  .action-buttons { flex-direction: column; align-items: center; }");
        out.println("  .btn { width: 200px; justify-content: center; }");
        out.println("}");

        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='result-container'>");

        // Header section
        out.println("<div class='performance-icon'>" + performanceIcon + "</div>");
        out.println("<div class='congratulations'>Quiz Completed!</div>");
        if (username != null) {
            out.println("<div class='username'><i class='fas fa-user'></i> " + username + "</div>");
        }

        // Score section
        out.println("<div class='score-section'>");
        out.println("<div class='main-score'>" + score + "/" + total + "</div>");
        out.println("<div class='score-details'>" + percentage + "% Correct</div>");
        out.println("<div class='performance-level'>" + performanceLevel + "</div>");
        out.println("</div>");

        // Statistics grid
        out.println("<div class='stats-grid'>");
        
        out.println("<div class='stat-item'>");
        out.println("<div class='stat-value'>" + score + "</div>");
        out.println("<div class='stat-label'>Correct</div>");
        out.println("</div>");
        
        out.println("<div class='stat-item'>");
        out.println("<div class='stat-value'>" + (total - score) + "</div>");
        out.println("<div class='stat-label'>Incorrect</div>");
        out.println("</div>");
        
        out.println("<div class='stat-item'>");
        out.println("<div class='stat-value'>" + bestScore + "</div>");
        out.println("<div class='stat-label'>Best Score</div>");
        out.println("</div>");
        
        out.println("</div>");

        // Action buttons
        out.println("<div class='action-buttons'>");
        out.println("<a href='question?restart=true' class='btn btn-primary'>");
        out.println("<i class='fas fa-redo'></i> Take Another Quiz");
        out.println("</a>");
        out.println("<a href='review' class='btn btn-info'>");
        out.println("<i class='fas fa-eye'></i> Review Answers");
        out.println("</a>");
        out.println("<button onclick=\"window.location.href='dashboard'\" class='btn btn-warning'>");
        out.println("<i class='fas fa-tachometer-alt'></i> Dashboard");
        out.println("</button>");
        out.println("<a href='logout' class='btn btn-danger'>");
        out.println("<i class='fas fa-sign-out-alt'></i> Logout");
        out.println("</a>");
        out.println("</div>");

        out.println("</div>");
        out.println("</body></html>");
    }

    private void generateErrorHTML(PrintWriter out, String errorMessage) {
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Error</title>");
        out.println("<link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css' rel='stylesheet'>");
        out.println("<style>");
        out.println("body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; display: flex; align-items: center; justify-content: center; margin: 0; }");
        out.println(".error-container { background: white; padding: 40px; border-radius: 20px; text-align: center; box-shadow: 0 10px 30px rgba(0,0,0,0.2); max-width: 500px; }");
        out.println(".error-icon { font-size: 4rem; color: #f44336; margin-bottom: 20px; }");
        out.println(".error-message { font-size: 1.2rem; color: #333; margin-bottom: 20px; }");
        out.println(".btn { display: inline-block; padding: 12px 25px; background: #2196F3; color: white; text-decoration: none; border-radius: 25px; font-weight: 600; transition: all 0.3s ease; }");
        out.println(".btn:hover { transform: translateY(-2px); box-shadow: 0 5px 15px rgba(0,0,0,0.2); }");
        out.println("</style>");
        out.println("</head><body>");
        out.println("<div class='error-container'>");
        out.println("<div class='error-icon'><i class='fas fa-exclamation-triangle'></i></div>");
        out.println("<div class='error-message'>" + errorMessage + "</div>");
        out.println("<a href='dashboard' class='btn'><i class='fas fa-home'></i> Go to Dashboard</a>");
        out.println("</div>");
        out.println("</body></html>");
    }

    private String getPerformanceLevel(int percentage) {
        if (percentage >= 90) return "Excellent";
        if (percentage >= 80) return "Great Job";
        if (percentage >= 70) return "Good Work";
        if (percentage >= 60) return "Fair";
        return "Keep Trying";
    }

    private String getPerformanceColor(int percentage) {
        if (percentage >= 90) return "#4CAF50";
        if (percentage >= 80) return "#8BC34A";
        if (percentage >= 70) return "#FF9800";
        if (percentage >= 60) return "#FF5722";
        return "#f44336";
    }

    private String getPerformanceIcon(int percentage) {
        if (percentage >= 90) return "<i class='fas fa-trophy'></i>";
        if (percentage >= 80) return "<i class='fas fa-medal'></i>";
        if (percentage >= 70) return "<i class='fas fa-thumbs-up'></i>";
        if (percentage >= 60) return "<i class='fas fa-star'></i>";
        return "<i class='fas fa-redo'></i>";
    }
}