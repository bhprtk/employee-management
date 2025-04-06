package org.example.project4;
import jakarta.servlet.ServletException;
import org.example.project4.dao.UserDAO;
import org.example.project4.dao.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Get the employee ID from the query parameter
        String idParam = request.getParameter("id");
        try {
            int id = Integer.parseInt(idParam);

            // Delete the employee from the database
            boolean isDeleted = userDAO.deleteEmployeeById(id);

            if (isDeleted) {
                System.out.println("Employee with ID " + id + " deleted successfully.");
            } else {
                System.out.println("Failed to delete employee with ID " + id);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid employee ID: " + idParam);
        }

        // Redirect back to the admin dashboard
        response.sendRedirect("adminDashboard");
    }
}
