package ServletAssignments.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rating")
public class movieForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Hardcoded movie rating data
    private static final Map<String, Movie> movieData = new HashMap<>();

    static {
        movieData.put("Inception", new Movie("Inception", "Sci-Fi", 8.8, "Mind-bending thriller with stunning visuals."));
        movieData.put("The Dark Knight", new Movie("The Dark Knight", "Action", 9.0, "A gripping, intense Batman movie."));
        movieData.put("Interstellar", new Movie("Interstellar", "Sci-Fi", 8.6, "A journey through space and time."));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movieName = request.getParameter("movieName");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (movieName != null && movieData.containsKey(movieName)) {
            Movie movie = movieData.get(movieName);
            out.println("<h2>Movie Rating Summary</h2>");
            out.println("<p><strong>Title:</strong> " + movie.getTitle() + "</p>");
            out.println("<p><strong>Genre:</strong> " + movie.getGenre() + "</p>");
            out.println("<p><strong>Rating:</strong> " + movie.getRating() + "</p>");
            out.println("<p><strong>Review:</strong> " + movie.getReview() + "</p>");
        } else {
            out.println("<h2>Movie '" + movieName + "' not found in our database.</h2>");
        }

        out.println("</body></html>");
        out.close();
    }

    // Helper class
    static class Movie {
        private String title;
        private String genre;
        private double rating;
        private String review;

        public Movie(String title, String genre, double rating, String review) {
            this.title = title;
            this.genre = genre;
            this.rating = rating;
            this.review = review;
        }

        public String getTitle() { return title; }
        public String getGenre() { return genre; }
        public double getRating() { return rating; }
        public String getReview() { return review; }
    }
}