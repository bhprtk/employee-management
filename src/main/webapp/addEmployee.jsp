<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<html lang="en">
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
  <title>Add Employee</title>
</head>
<body>
<div class="container mt-5">
  <h1 class="text-center mb-4">Add New Employee</h1>
  <form action="addEmployee" method="POST">
    <div class="mb-3">
      <label for="firstName" class="form-label">First Name:</label>
      <input type="text" id="firstName" name="firstName" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="lastName" class="form-label">Last Name:</label>
      <input type="text" id="lastName" name="lastName" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="username" class="form-label">Username:</label>
      <input type="text" id="username" name="username" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="role" class="form-label">Role:</label>
      <select id="role" name="role" class="form-select" required>
        <option value="admin">Admin</option>
        <option value="employee">Employee</option>
      </select>
    </div>
    <div class="mb-3">
      <label for="email" class="form-label">Email:</label>
      <input type="email" id="email" name="email" class="form-control" required>
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">Password:</label>
      <input type="password" id="password" name="password" class="form-control" required>
    </div>
    <button type="submit" class="btn btn-primary w-100">Add Employee</button>
  </form>
</div>
</body>
</html>
