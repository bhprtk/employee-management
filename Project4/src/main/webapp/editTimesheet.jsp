<%@ page import="org.example.project4.dao.Attendance" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>
<%
  // Check if the user is logged in
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
  <title>Edit Timesheet</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center mb-4">Edit Timesheet</h1>
  <%
    Attendance attendance = (Attendance) request.getAttribute("attendance");
  %>
  <form action="updateTimesheet" method="POST">
    <input type="hidden" name="id" value="<%= attendance.getId() %>">
    <input type="hidden" name="employeeId" value="<%= attendance.getEmployeeId() %>"> <!-- Pass employeeId -->
    <div class="mb-3">
      <label for="date" class="form-label">Date:</label>
      <input type="date" id="date" name="date" class="form-control"
             value="<%= new java.text.SimpleDateFormat("yyyy-MM-dd").format(attendance.getDate()) %>" required>
    </div>
    <div class="mb-3">
      <label for="timeIn" class="form-label">Time In:</label>
      <input type="time" id="timeIn" name="timeIn" class="form-control"
             value="<%= new java.text.SimpleDateFormat("HH:mm").format(attendance.getTimeIn()) %>" required>
    </div>
    <div class="mb-3">
      <label for="timeOut" class="form-label">Time Out:</label>
      <input type="time" id="timeOut" name="timeOut" class="form-control"
             value="<%= attendance.getTimeOut() != null ? new java.text.SimpleDateFormat("HH:mm").format(attendance.getTimeOut()) : "" %>">
    </div>
    <button type="submit" class="btn btn-primary w-100">Update Timesheet</button>
  </form>
</div>
</body>
</html>
