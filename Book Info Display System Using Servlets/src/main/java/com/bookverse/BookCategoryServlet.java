package com.bookverse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BookCategoryServlet extends HttpServlet {

    private String storeName;
    private String adminEmail;
    private String category;

    private static final Map<String, String[]> CATEGORY_BOOKS = new HashMap<>();

    static {
        CATEGORY_BOOKS.put("Fiction", new String[]{
            "The Great Gatsby - F. Scott Fitzgerald",
            "To Kill a Mockingbird - Harper Lee",
            "1984 - George Orwell",
            "Pride and Prejudice - Jane Austen",
            "The Catcher in the Rye - J.D. Salinger"
        });

        CATEGORY_BOOKS.put("Science", new String[]{
            "A Brief History of Time - Stephen Hawking",
            "The Origin of Species - Charles Darwin",
            "Cosmos - Carl Sagan",
            "The Double Helix - James Watson",
            "Silent Spring - Rachel Carson"
        });

        CATEGORY_BOOKS.put("Technology", new String[]{
            "Clean Code - Robert Martin",
            "The Pragmatic Programmer - Hunt & Thomas",
            "Design Patterns - Gang of Four",
            "Structure and Interpretation of Computer Programs - Abelson",
            "The Art of Computer Programming - Donald Knuth"
        });
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storeName = config.getInitParameter("storeName");
        adminEmail = config.getInitParameter("adminEmail");
        category = config.getInitParameter("category");

        ServletContext context = getServletContext();
        synchronized (context) {   // Only one thread at a time can enter this block.
            if (context.getAttribute("dynamicBooks") == null) {
                context.setAttribute("dynamicBooks", new HashMap<String, List<String>>());
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        ServletContext context = getServletContext();
        
        Map<String, List<String>> dynamicBooks = (Map<String, List<String>>) context.getAttribute("dynamicBooks");

        String action = request.getParameter("action");
        if ("remove".equals(action)) {
            String bookToRemove = request.getParameter("bookName");
            if (bookToRemove != null && dynamicBooks.containsKey(category)) {
                dynamicBooks.get(category).remove(URLDecoder.decode(bookToRemove, "UTF-8"));
            }
        } else {
            String newBook = request.getParameter("newBook");
            if (newBook != null && !newBook.trim().isEmpty()) {
                dynamicBooks.computeIfAbsent(category, k -> new ArrayList<>()).add(newBook.trim());
            }
        }
        response.sendRedirect(request.getRequestURI());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        ServletContext context = getServletContext();

        String countAttribute = category.toLowerCase() + "Count";
        synchronized (context) {
            Integer categoryCount = (Integer) context.getAttribute(countAttribute);
            categoryCount = (categoryCount == null) ? 1 : categoryCount + 1;
            context.setAttribute(countAttribute, categoryCount);
        }

        Integer totalVisitors = (Integer) context.getAttribute("totalVisitors");
        Integer categoryCount = (Integer) context.getAttribute(countAttribute);
        String appVersion = context.getInitParameter("appVersion");

        out.println("<!DOCTYPE html><html><head><title>" + category + " Books - BookVerse</title>");
        
        out.println("<style>");
        out.println("body { font-family: Arial; background-color: #f8f9fa; padding: 40px; }");
        out.println(".container { max-width: 800px; margin: auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }");
        out.println("h1 { color: #27ae60; text-align: center; }");
        out.println(".info-section, .stats-section, .books-section { margin: 20px 0; padding: 15px; border-radius: 5px; }");
        out.println(".info-section { background: #e8f5e8; border-left: 4px solid #27ae60; }");
        out.println(".stats-section { background: #fff3cd; border-left: 4px solid #ffc107; }");
        out.println(".books-section { background: #f8f9fa; }");
        out.println("ul { list-style-type: none; padding: 0; }");
        out.println("li { padding: 8px; margin: 5px 0; background: white; border-radius: 3px; border-left: 3px solid #3498db; display: flex; justify-content: space-between; align-items: center; }");
        out.println(".remove-btn { background: red; color: white; border: none; padding: 3px 8px; border-radius: 3px; cursor: pointer; }");
        out.println(".nav-links a { display: inline-block; margin: 5px 10px 0 0; padding: 8px 15px; background: #6c757d; color: white; text-decoration: none; border-radius: 5px; }");
        out.println(".nav-links a:hover { background: #5a6268; }");
        out.println("form { margin-top: 20px; } input[type=text] { width: 70%; padding: 8px; }");
        out.println("input[type=submit] { padding: 8px 16px; background-color: #27ae60; color: white; border: none; border-radius: 4px; cursor: pointer; }");
        out.println("input[type=submit]:hover { background-color: #219150; }");
        out.println("</style>"
        		+ "</head>"
        		+ "<body>"
        		+ "<div class='container'>");

        out.println("<h1>🔹 " + category + " Category</h1>");

        out.println("<div class='info-section'><h3>📚 Book Category: " + category + "</h3>");
        out.println("<table><tr><th>Configuration</th><th>Value</th></tr>");
        out.println("<tr><td><strong>Store:</strong></td><td>" + storeName + "</td></tr>");
        out.println("<tr><td><strong>Admin Email:</strong></td><td>" + adminEmail + "</td></tr>");
        out.println("</table></div>");

        out.println("<div class='stats-section'><h3>📊 Visitor Statistics</h3>");
        out.println("<table><tr><th>Statistic</th><th>Count</th></tr>");
        out.println("<tr><td><strong>" + category + " Books Visited:</strong></td><td>" + categoryCount + "</td></tr>");
        out.println("<tr><td><strong>Total Visitors:</strong></td><td>" + totalVisitors + "</td></tr>");
        out.println("<tr><td><strong>App Version:</strong></td><td>" + appVersion + "</td></tr>");
        out.println("</table></div>");

        out.println("<div class='books-section'><h3>📖 Popular " + category + " Books</h3><ul>");

        String[] books = CATEGORY_BOOKS.get(category);
        if (books != null) {
            for (String book : books) {
                out.println("<li>" + book + "</li>");
            }
        }

        Map<String, List<String>> dynamicBooks = (Map<String, List<String>>) context.getAttribute("dynamicBooks");
        List<String> addedBooks = dynamicBooks.get(category);
        if (addedBooks != null) {
            for (String book : addedBooks) {
                String encodedBook = java.net.URLEncoder.encode(book, "UTF-8");
                out.println("<li>" + book +
                        "<form method='post' style='display:inline; margin-left:10px;'>" +
                        "<input type='hidden' name='action' value='remove'>" +
                        "<input type='hidden' name='bookName' value='" + encodedBook + "'>" +
                        "<input type='submit' class='remove-btn' value='remove'>" +
                        "</form></li>");
            }
        }

        out.println("</ul>");
        out.println("<form method='post'>");
        out.println("<input type='text' name='newBook' placeholder='Add a new popular book...' required>");
        out.println("<input type='submit' value='Add Book'>");
        out.println("</form>");
        out.println("</div>"); // books-section

        out.println("<div class='nav-links'>");
        out.println("<a href='welcome'>🏠 Home</a>");
        out.println("<a href='fiction'>📚 Fiction</a>");
        out.println("<a href='science'>🔬 Science</a>");
        out.println("<a href='technology'>💻 Technology</a>");
        out.println("<a href='admin'>🔧 Admin</a>");
        out.println("</div>");

        out.println("</div></body></html>");
    }
}
