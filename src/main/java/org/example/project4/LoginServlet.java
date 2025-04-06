package org.example.project4;

import org.example.project4.dao.UserDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.ServletException;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO(); // Initialize the DAO

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("in login doGet");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("in login doPost");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check user role using DAO
        String role = userDAO.getUserRole(username, password);
        if (role != null) {
            // Create a session for the authenticated user
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("role", role);


            if ("admin".equalsIgnoreCase(role)) {
                // Redirect admin users to the admin dashboard
                response.sendRedirect("adminDashboard");
            } else if ("employee".equalsIgnoreCase(role)) {
                // Redirect employee users to the employee dashboard
                response.sendRedirect("employeeDashboard");

            }
        } else {
            // Invalid credentials
            request.setAttribute("errorMessage", "Invalid username or password!");
            request.getRequestDispatcher("login").forward(request, response);
        }
    }
}
