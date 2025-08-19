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

@WebServlet("/stock")

public class ProductStockServlet extends HttpServlet {
 

    // Simulated product inventory
    private static final Map<String, Product> inventory = new HashMap<>();

    static {
        inventory.put("1001", new Product("Wireless Mouse", 15));
        inventory.put("1002", new Product("Bluetooth Headphones", 0));
        inventory.put("1005", new Product("USB-C Charger", 25));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("productId");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        if (productId != null && inventory.containsKey(productId)) {
            Product product = inventory.get(productId);
            out.println("<h2>Product Stock Details</h2>");
            out.println("<p><strong>Product ID:</strong> " + productId + "</p>");
            out.println("<p><strong>Product Name:</strong> " + product.getName() + "</p>");
            out.println("<p><strong>Availability:</strong> " + 
                        (product.getStock() > 0 ? "In Stock" : "Out of Stock") + "</p>");
            out.println("<p><strong>Stock Count:</strong> " + product.getStock() + "</p>");
        } else {
            out.println("<h2>Product with ID '" + productId + "' not found.</h2>");
        }
        out.println("<br><a href='productForm.html'>Back to product form</a>");

        out.println("</body></html>");
        out.close();
    }

    // Inner class to represent a product
    static class Product {
        private String name;
        private int stock;

        public Product(String name, int stock) {
            this.name = name;
            this.stock = stock;
        }

        public String getName() {
            return name;
        }

        public int getStock() {
            return stock;
        }
    }
}