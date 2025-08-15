package com.aurionpro.model;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOGGER.info("Received login request");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Sanitize inputs
        username = username != null ? username.trim() : "";
        password = password != null ? password.trim() : "";

        response.setContentType("text/html;charset=UTF-8");

        // Basic validation
        if (username.isEmpty() || password.isEmpty()) {
            LOGGER.warning("Empty credentials provided");
            sendErrorResponse(response, "Please enter both username and password.");
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            LOGGER.info("Database connection established for login");

            // Query to get user details
            String sql = "SELECT id, username, password FROM users WHERE username = ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, username);
                
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String storedPassword = rs.getString("password");
                        String hashedInputPassword = hashPassword(password);
                        
                        // Check if password matches (try both hashed and plain text for backward compatibility)
                        if (storedPassword.equals(hashedInputPassword) || storedPassword.equals(password)) {
                            // Login successful
                            int userId = rs.getInt("id");
                            String dbUsername = rs.getString("username");
                            
                            // Create session
                            HttpSession session = request.getSession();
                            session.setAttribute("userId", userId);
                            session.setAttribute("username", dbUsername);
                            session.setMaxInactiveInterval(30 * 60); // 30 minutes
                            
                            LOGGER.info("User logged in successfully: " + username);
                            response.sendRedirect("dashboard");
                        } else {
                            LOGGER.warning("Invalid password for username: " + username);
                            sendErrorResponse(response, "Invalid username or password.");
                        }
                    } else {
                        LOGGER.warning("Username not found: " + username);
                        sendErrorResponse(response, "Invalid username or password.");
                    }
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception during login for username: " + username, e);
            sendErrorResponse(response, "An error occurred during login. Please try again later.");
        }

        LOGGER.info("Login process finished for username: " + username);
    }

    /**
     * Hashes password using SHA-256
     */
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes("UTF-8"));
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | java.io.UnsupportedEncodingException e) {
            LOGGER.log(Level.SEVERE, "Error hashing password", e);
            // Fallback to plain text (not recommended for production)
            return password;
        }
    }

    /**
     * Sends error response with enhanced styling
     */
    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException {
        response.getWriter().println(generateErrorHTML(message));
    }

    /**
     * Generates styled HTML error response
     */
    private String generateErrorHTML(String message) {
        return "<!DOCTYPE html>" +
               "<html><head>" +
               "<title>Login Error</title>" +
               "<style>" +
               "body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); margin: 0; padding: 20px; min-height: 100vh; display: flex; align-items: center; justify-content: center; }" +
               ".message-container { background: white; padding: 40px; border-radius: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.2); text-align: center; max-width: 500px; animation: slideIn 0.5s ease-out; }" +
               ".icon { font-size: 4rem; color: #f44336; margin-bottom: 20px; }" +
               ".message { font-size: 1.2rem; margin-bottom: 30px; color: #333; line-height: 1.5; }" +
               ".redirect-info { color: #666; font-size: 0.9rem; margin-bottom: 20px; }" +
               "@keyframes slideIn { from { opacity: 0; transform: translateY(-50px); } to { opacity: 1; transform: translateY(0); } }" +
               "</style>" +
               "</head><body>" +
               "<div class='message-container'>" +
               "<div class='icon'>✗</div>" +
               "<div class='message'>" + message + "</div>" +
               "<div class='redirect-info'>You will be redirected to login page...</div>" +
               "</div>" +
               "<script>setTimeout(function(){ window.location='login.html'; }, 3000);</script>" +
               "</body></html>";
    }
}