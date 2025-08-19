package ServletAssignments.Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class CourseCatalog extends HttpServlet{
	private static final Map<String , List<String>> courseCatalog = new HashMap<>();
	static {
		courseCatalog.put("CS",List.of("CS101 - Data Structure" ,  "CS102 - Algorithms", "CS103 - Operating Systems"));
        courseCatalog.put("ME", List.of("ME101 - Thermodynamics", "ME102 - Fluid Mechanics", "ME103 - CAD"));
        courseCatalog.put("EE", List.of("EE101 - Circuits", "EE102 - Electromagnetics", "EE103 - Power Systems"));
	}

	
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String department = request.getParameter("department");

    response.setContentType("text/html");
    PrintWriter pw = response.getWriter();

    pw.println("<html><body>");

    if (department != null && courseCatalog.containsKey(department.toUpperCase())) {
        pw.println("<h2>Courses for Department: " + department.toUpperCase() + "</h2><ul>");
        for (String course : courseCatalog.get(department.toUpperCase())) {
            pw.println("<li>" + course + "</li>");
        }
        pw.println("</ul>");
    }

    pw.println("</body></html>");
    pw.close();

}
}	

