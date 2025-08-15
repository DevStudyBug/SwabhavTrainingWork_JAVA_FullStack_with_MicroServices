package com.aurionpro.model;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(RegisterServlet.class.getName());

    // Enhanced regex patterns for validation
    private static final String PASSWORD_REGEX =
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    
    private static final String EMAIL_REGEX = 
            "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    
    private static final String USERNAME_REGEX = 
            "^[a-zA-Z0-9_]{3,20}$";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LOGGER.info("Received registration request");

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Sanitize inputs
        username = username != null ? username.trim() : "";
        email = email != null ? email.trim().toLowerCase() : "";
        password = password != null ? password.trim() : "";

        LOGGER.info("Registration attempt for username: " + username + ", email: " + email);

        response.setContentType("text/html;charset=UTF-8");

        // Comprehensive validation
        String validationError = validateInput(username, email, password);
        if (validationError != null) {
            LOGGER.warning("Validation failed: " + validationError + " for username: " + username);
            sendErrorResponse(response, validationError);
            return;
        }

        try (Connection con = DBConnection.getConnection()) {
            LOGGER.info("Database connection established");

            // Check if username already exists
            if (isUsernameExists(con, username)) {
                LOGGER.warning("Username already exists: " + username);
                sendErrorResponse(response, "Username already exists! Please choose a different one.");
                return;
            }

            // Check if email already exists
            if (isEmailExists(con, email)) {
                LOGGER.warning("Email already exists: " + email);
                sendErrorResponse(response, "Email already registered! Please use a different email or try logging in.");
                return;
            }

            // Hash password before storing
            String hashedPassword = hashPassword(password);
            
            // Insert new user
            String insertSql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(insertSql)) {
                pst.setString(1, username);
                pst.setString(2, email);
                pst.setString(3, hashedPassword);

                int inserted = pst.executeUpdate();

                if (inserted > 0) {
                    LOGGER.info("User registered successfully: " + username);
                    sendSuccessResponse(response, "Registration successful! Please log in with your credentials.");
                } else {
                    LOGGER.warning("User registration failed for username: " + username);
                    sendErrorResponse(response, "Registration failed! Please try again.");
                }
            }

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Exception during registration for username: " + username, e);
            sendErrorResponse(response, "An error occurred during registration. Please try again later.");
        }

        LOGGER.info("Registration process finished for username: " + username);
    }

    /**
     * Validates user input
     */
    private String validateInput(String username, String email, String password) {
        if (username == null || username.isEmpty()) {
            return "Username is required";
        }
        
        if (email == null || email.isEmpty()) {
            return "Email is required";
        }
        
        if (password == null || password.isEmpty()) {
            return "Password is required";
        }

        if (!Pattern.matches(USERNAME_REGEX, username)) {
            return "Username must be 3-20 characters long and contain only letters, numbers, and underscores";
        }

        if (!Pattern.matches(EMAIL_REGEX, email)) {
            return "Please enter a valid email address";
        }

        if (!Pattern.matches(PASSWORD_REGEX, password)) {
            return "Password must be at least 8 characters long and contain: uppercase letter, lowercase letter, digit, and special character (@$!%*?&)";
        }

        return null; // No validation errors
    }

    /**
     * Checks if username already exists
     */
    private boolean isUsernameExists(Connection con, String username) throws Exception {
        String sql = "SELECT id FROM users WHERE username = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }

    /**
     * Checks if email already exists
     */
    private boolean isEmailExists(Connection con, String email) throws Exception {
        String sql = "SELECT id FROM users WHERE email = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
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
        response.getWriter().println(generateResponseHTML(message, "error", "register.html"));
    }

    /**
     * Sends success response with enhanced styling
     */
    private void sendSuccessResponse(HttpServletResponse response, String message) throws IOException {
        response.getWriter().println(generateResponseHTML(message, "success", "login.html"));
    }

    /**
     * Generates styled HTML response
     */
    private String generateResponseHTML(String message, String type, String redirectUrl) {
        String bgColor = type.equals("success") ? "#4CAF50" : "#f44336";
        String icon = type.equals("success") ? "✓" : "✗";
        
        return "<!DOCTYPE html>" +
               "<html><head>" +
               "<title>Registration " + (type.equals("success") ? "Success" : "Error") + "</title>" +
               "<style>" +
               "body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); margin: 0; padding: 20px; min-height: 100vh; display: flex; align-items: center; justify-content: center; }" +
               ".message-container { background: white; padding: 40px; border-radius: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.2); text-align: center; max-width: 500px; animation: slideIn 0.5s ease-out; }" +
               ".icon { font-size: 4rem; color: " + bgColor + "; margin-bottom: 20px; }" +
               ".message { font-size: 1.2rem; margin-bottom: 30px; color: #333; line-height: 1.5; }" +
               ".redirect-info { color: #666; font-size: 0.9rem; margin-bottom: 20px; }" +
               "@keyframes slideIn { from { opacity: 0; transform: translateY(-50px); } to { opacity: 1; transform: translateY(0); } }" +
               "</style>" +
               "</head><body>" +
               "<div class='message-container'>" +
               "<div class='icon'>" + icon + "</div>" +
               "<div class='message'>" + message + "</div>" +
               "<div class='redirect-info'>You will be redirected automatically...</div>" +
               "</div>" +
               "<script>setTimeout(function(){ window.location='" + redirectUrl + "'; }, 3000);</script>" +
               "</body></html>";
    }
}