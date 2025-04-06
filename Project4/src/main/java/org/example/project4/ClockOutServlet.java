package org.example.project4;
import jakarta.servlet.http.HttpSession;
import org.example.project4.dao.UserDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/clockOut")
public class ClockOutServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        HttpSession session = request.getSession();
        Integer employeeId = (Integer) session.getAttribute("employeeId");

        if (employeeId == null) {
            response.sendRedirect("login");
            return;
        }

        boolean isClockedOut = userDAO.clockOut(employeeId);
        session.setAttribute("isClockedIn", false); // Update session to reflect clock-out status

        response.sendRedirect("employeeDashboard?message=Clock-out successful");
    }
}
