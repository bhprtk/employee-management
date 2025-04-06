package org.example.project4;

import jakarta.servlet.ServletException;
import org.example.project4.dao.UserDAO;
import org.example.project4.dao.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet for handling the addition of new employees.
 * Provides functionality to display the form (GET request) and process form submissions (POST request).
 */
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    /**
     * Handles GET requests to display the "Add Employee" form.
     *
     * @param request  The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws IOException      If an input or output error occurs.
     * @throws ServletException If a servlet-specific error occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("doGet in add employee");

        // Forward to JSP
        request.getRequestDispatcher("addEmployee.jsp").forward(request, response);

    }
    /**
     * Handles GET requests to display the "Add Employee" form.
     *
     * @param request  The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws IOException      If an input or output error occurs.
     * @throws ServletException If a servlet-specific error occurs.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Retrieve form parameters
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create new employee object
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setRole(role);
        employee.setEmail(email);
        employee.setPassword(password);

        // Add employee to database
        userDAO.addEmployee(employee);

        // Redirect back to admin dashboard
        response.sendRedirect("adminDashboard");
    }
}
