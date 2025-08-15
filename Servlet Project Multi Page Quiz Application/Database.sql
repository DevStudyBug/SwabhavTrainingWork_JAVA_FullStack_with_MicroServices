-- mysql database for quiz application 

CREATE DATABASE IF NOT EXISTS multi_page_quiz_application;
USE multi_page_quiz_application;

-- Users Table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Questions Table
CREATE TABLE IF NOT EXISTS questions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    question_text VARCHAR(255) NOT NULL,
    option_a VARCHAR(100) NOT NULL,
    option_b VARCHAR(100) NOT NULL,
    option_c VARCHAR(100) NOT NULL,
    option_d VARCHAR(100) NOT NULL,
    correct_option CHAR(1) NOT NULL CHECK (correct_option IN ('A','B','C','D')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Results Table (FIXED: Removed quiz_name column that doesn't exist in your code)
CREATE TABLE IF NOT EXISTS results (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    score INT NOT NULL CHECK (score >= 0),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id) 
        ON DELETE CASCADE 
        ON UPDATE CASCADE
);

-- Indexes for better performance
CREATE INDEX idx_user_id ON results(user_id);
CREATE INDEX idx_question_text ON questions(question_text);

-- Sample Questions
INSERT INTO questions 
(question_text, option_a, option_b, option_c, option_d, correct_option) VALUES
('Which method in HttpServlet is used to handle POST requests?', 'doGet()', 'doPost()', 'service()', 'init()', 'B'),
('Which object is used to share data between servlets?', 'HttpSession', 'ServletContext', 'RequestDispatcher', 'Cookie', 'B'),
('Which HTTP status code represents "Not Found"?', '200', '301', '404', '500', 'C'),
('In Servlets, which method is called only once during the servlet lifecycle?', 'doGet()', 'service()', 'init()', 'destroy()', 'C'),
('Which design pattern does HttpServletRequest and HttpServletResponse follow?', 'Singleton', 'Factory', 'Decorator', 'Adapter', 'D'),
('Which design pattern is used in JDBC DriverManager to load different database drivers?', 'Singleton', 'Factory', 'Prototype', 'Builder', 'B'),
('In MVC architecture, Servlets usually act as the?', 'Model', 'View', 'Controller', 'Database', 'C'),
('Which method is used to forward a request to another resource in a servlet?', 'sendRedirect()', 'forward()', 'include()', 'chain()', 'B'),
('Which design pattern ensures only one instance of a class exists?', 'Singleton', 'Prototype', 'Observer', 'Strategy', 'A'),
('Which method in HttpServlet is thread-safe by default?', 'doGet()', 'doPost()', 'init()', 'None of the above', 'D');
