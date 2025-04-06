<%@ page import="org.example.project4.dao.Employee" %>

<%@ page import="java.util.List" %>
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
    String currentUsername = (String) session.getAttribute("username");

%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Admin Dashboard</h1>
    <div class="text-center">
        <a href="addEmployee" class="text-center btn btn-outline-primary">Add Employee</a>
    </div>

    <%
        List<Employee> employees = (List<Employee>) request.getAttribute("employees");
        if (employees == null || employees.isEmpty()) {
    %>
    <p class="text-center text-danger">No employees found.</p>
    <%
    } else {
    %>
    <h3 class="\mb-4">All Employees</h3>
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
            <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Role</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Employee employee : employees) {
            %>
            <tr>
                <td><%= employee.getId() %></td>
                <td><%= employee.getFirstName() %></td>
                <td><%= employee.getLastName() %></td>
                <td><%= employee.getUsername() %></td>
                <td><%= employee.getRole() %></td>
                <td><%= employee.getEmail() %></td>
                <td>
                    <!-- Edit Button -->
                    <a href="editEmployee?id=<%= employee.getId() %>" class="btn btn-outline-success btn-sm">Edit</a>
                    <!-- Delete Button -->
                    <% if (!employee.getUsername().equals(currentUsername)) { %>
                    <a href="deleteEmployee?id=<%= employee.getId() %>" class="btn btn-outline-danger btn-sm"
                       onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                    <a href="viewTimesheet?id=<%= employee.getId() %>" class="btn btn-outline-info btn-sm">View Timesheet</a>
                    <% } %>




                </td>

            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <%
        }
    %>
</div>
</body>
</html>

