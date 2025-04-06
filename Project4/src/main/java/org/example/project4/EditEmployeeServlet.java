package org.example.project4;

import jakarta.servlet.ServletException;
import org.example.project4.dao.UserDAO;
import org.example.project4.dao.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/editEmployee")
public class EditEmployeeServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the employee ID from the query parameter
        String id = request.getParameter("id");

        try {
            // Fetch the employee details
            Employee employee = userDAO.getEmployeeById(Integer.parseInt(id));
            if (employee != null) {
                // Pass the employee details to the JSP
                request.setAttribute("employee", employee);
                request.getRequestDispatcher("editEmployee.jsp").forward(request, response);
            } else {
                // If no employee found, redirect to the admin dashboard with an error message
                response.sendRedirect("adminDashboard?error=EmployeeNotFound");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("adminDashboard?error=InvalidEmployeeId");
        }
    }
}
