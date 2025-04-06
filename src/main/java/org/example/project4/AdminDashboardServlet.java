package org.example.project4;

import jakarta.servlet.ServletException;
import org.example.project4.dao.UserDAO;
import org.example.project4.dao.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/adminDashboard")
public class AdminDashboardServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        System.out.println("doGet in admin dashboard");

        // Fetch all employees
        List<Employee> employees = userDAO.getAllEmployees();

        // Pass the list of employees to the JSP
        request.setAttribute("employees", employees);

        // Forward to JSP
        request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);



    }
}
