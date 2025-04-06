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

@WebServlet("/viewTimesheet")
public class ViewTimesheetServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the employee ID from the query parameter
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            response.sendRedirect("adminDashboard?error=InvalidEmployeeId");
            return;
        }

        try {
            int employeeId = Integer.parseInt(idParam);

            // Fetch employee details (optional: display their name in the timesheet page)
            Employee employee = userDAO.getCurrentEmployeeById(employeeId);

            // Fetch attendance records for the employee
            List<Attendance> attendanceList = userDAO.getAttendanceByEmployeeId(employeeId);

            // Pass the data to the JSP
            request.setAttribute("employee", employee);
            request.setAttribute("attendanceList", attendanceList);
            request.getRequestDispatcher("viewTimesheet.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("adminDashboard?error=InvalidEmployeeId");
        }
    }
}

