package org.example.project4;
import jakarta.servlet.ServletException;
import org.example.project4.dao.UserDAO;
import org.example.project4.dao.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Retrieve form parameters
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String role = request.getParameter("role");
        String email = request.getParameter("email");

        // Update employee
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setRole(role);
        employee.setEmail(email);

        userDAO.updateEmployee(employee);

        // Redirect back to admin dashboard
        response.sendRedirect("adminDashboard");
    }
}
