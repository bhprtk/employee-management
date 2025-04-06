package org.example.project4;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import org.example.project4.dao.Attendance;
import org.example.project4.dao.UserDAO;
import org.example.project4.dao.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/employeeDashboard")
public class EmployeeDashboardServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Get username from session
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login");
            return;
        }
        // Get the current employee's ID using the username
        Employee currentEmployee = userDAO.getCurrentEmployeeByUserName(username);
        if (currentEmployee == null) {
            response.sendRedirect("login");
            return;
        }

        // Fetch all attendance records for the current employee
        List<Attendance> attendanceList = userDAO.getAttendanceByEmployeeId(currentEmployee.getId());
        request.setAttribute("attendanceList", attendanceList);
        // Pass the list of employees to the JSP
        request.setAttribute("currentEmployee", currentEmployee);

        session.setAttribute("employeeId", currentEmployee.getId());
        // Check clock-in status and set it in the session
        boolean isClockedIn = userDAO.isClockedIn(currentEmployee.getId());
        session.setAttribute("isClockedIn", isClockedIn);
        // Forward to JSP
        request.getRequestDispatcher("employeeDashboard.jsp").forward(request, response);


    }
}
