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

@WebServlet("/deleteTimesheet")
public class DeleteTimesheetServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean success = userDAO.deleteAttendance(id);
        int employeeId = Integer.parseInt(request.getParameter("employeeId")); // Ensure this is passed in the request

        System.out.println("employeeId: " + employeeId);
        if (success) {
            response.sendRedirect("viewTimesheet?id=" + employeeId);
        } else {
            response.sendRedirect("viewTimesheet?id=" + employeeId + "&error=UpdateFailed");
        }
    }
}

