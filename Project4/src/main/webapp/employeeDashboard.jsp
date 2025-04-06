<%@ page import="org.example.project4.dao.Employee" %>
<%@ page import="org.example.project4.dao.Attendance" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>
<%
  // Check if the user is logged in
  if (session == null || session.getAttribute("username") == null) {
    response.sendRedirect("login.jsp");
    return;
  }
  // Create a date formatter
  SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");
  SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Employee Dashboard</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
  <div class="container text-center mt-5">
    <h1 class="mb-4">Employee Dashboard</h1>
  </div>

  <div class="text-center">
    <%
      Boolean isClockedIn = (Boolean) session.getAttribute("isClockedIn");
      if (isClockedIn != null && isClockedIn) {
    %>
    <h4>You are currently clocked in.</h4>
    <a href="clockOut" class="btn btn-outline-secondary">Clock Out</a>
    <%
    } else {
    %>
    <h4>You are currently clocked out.</h4>
    <a href="clockIn" class="btn btn-outline-info">Clock In</a>
    <%
      }
    %>
  </div>

  <div class="container mt-5">
    <h3 class="text-center mb-4">Your Attendance</h3>
    <%
      List<Attendance> attendanceList = (List<Attendance>) request.getAttribute("attendanceList");
      if (attendanceList == null || attendanceList.isEmpty()) {
    %>
    <p class="text-center text-danger">No attendance records found.</p>
    <%
    } else {
    %>
    <table class="table table-striped table-bordered">
      <thead class="table-dark">
      <tr>
        <th>Date</th>
        <th>Time In</th>
        <th>Time Out</th>
      </tr>
      </thead>
      <tbody>
      <%
        for (Attendance attendance : attendanceList) {
      %>
      <tr>
        <td><%= dateFormatter.format(attendance.getDate()) %></td>
        <td><%= attendance.getTimeIn() != null ? timeFormatter.format(attendance.getTimeIn()) : "N/A" %></td>
        <td><%= attendance.getTimeOut() != null ? timeFormatter.format(attendance.getTimeOut()) : "N/A" %></td>
      </tr>
      <%
        }
      %>
      </tbody>
    </table>
    <%
      }
    %>
  </div>


</body>
</html>

