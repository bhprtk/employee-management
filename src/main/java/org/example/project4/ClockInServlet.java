package org.example.project4;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpSession;
import org.example.project4.dao.UserDAO;
import org.example.project4.dao.Employee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/clockIn")
public class ClockInServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        // Get the employee ID from the session
        HttpSession session = request.getSession();
        Integer employeeId = (Integer) session.getAttribute("employeeId");

        if (employeeId == null) {
            // Redirect to login if the user is not logged in
            response.sendRedirect("login");
            return;
        }

        // Record the clock-in time
        boolean isClockedIn = userDAO.clockIn(employeeId);
        session.setAttribute("isClockedIn", true); // Update session to reflect clock-in status

        if (isClockedIn) {
            response.sendRedirect("employeeDashboard?message=Clock-in successful");
        } else {
            response.sendRedirect("employeeDashboard?error=Clock-in failed");
        }
    }
}
