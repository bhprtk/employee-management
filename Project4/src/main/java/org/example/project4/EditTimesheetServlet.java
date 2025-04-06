package org.example.project4;
import jakarta.servlet.ServletException;
import org.example.project4.dao.Attendance;
import org.example.project4.dao.UserDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/editTimesheet")
public class EditTimesheetServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");

        try {
            int timesheetId = Integer.parseInt(idParam);

            // Fetch the timesheet entry by ID
            Attendance attendance = userDAO.getAttendanceById(timesheetId);

            if (attendance == null) {
                response.sendRedirect("viewTimesheet?error=TimesheetNotFound");
                return;
            }

            // Forward the entry to the edit page
            request.setAttribute("attendance", attendance);
            request.getRequestDispatcher("editTimesheet.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("viewTimesheet?error=InvalidTimesheetId");
        }
    }
}
