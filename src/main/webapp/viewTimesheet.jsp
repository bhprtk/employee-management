<%@ page import="org.example.project4.dao.Attendance" %>
<%@ page import="org.example.project4.dao.Employee" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>
<%
    if (session == null ||
            session.getAttribute("username") == null ||
            !"admin".equalsIgnoreCase(session.getAttribute("role").toString())) {
        response.sendRedirect("employeeDashboard");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Timesheet</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Employee Timesheet</h1>
    <%
        Employee employee = (Employee) request.getAttribute("employee");
    %>
    <h3 class="text-center mb-4">Timesheet for: <%= employee.getFirstName() + " " + employee.getLastName() %></h3>

    <%
        List<Attendance> attendanceList = (List<Attendance>) request.getAttribute("attendanceList");
        if (attendanceList == null || attendanceList.isEmpty()) {
    %>
    <p class="text-center text-danger">No attendance records found for this employee.</p>
    <%
    } else {
    %>
    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>Date</th>
            <th>Time In</th>
            <th>Time Out</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Attendance attendance : attendanceList) {
        %>
        <tr>
            <td><%= new java.text.SimpleDateFormat("MMMM dd, yyyy").format(attendance.getDate()) %></td>
            <td><%= attendance.getTimeIn() != null ? new java.text.SimpleDateFormat("hh:mm a").format(attendance.getTimeIn()) : "N/A" %></td>
            <td><%= attendance.getTimeOut() != null ? new java.text.SimpleDateFormat("hh:mm a").format(attendance.getTimeOut()) : "N/A" %></td>
            <td>
                <a href="editTimesheet?id=<%= attendance.getId() %>" class="btn btn-outline-success btn-sm">Edit</a>
                <a href="deleteTimesheet?id=<%= attendance.getId() %>&employeeId=<%= attendance.getEmployeeId() %>"
                   class="btn btn-outline-danger btn-sm"
                   onclick="return confirm('Are you sure you want to delete this timesheet entry?');">Delete</a>

            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        }
    %>
    <div class="text-center mt-4">
        <a href="adminDashboard" class="btn btn-outline-secondary">Back to Dashboard</a>
    </div>
</div>
</body>
</html>
