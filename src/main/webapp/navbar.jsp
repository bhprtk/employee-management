<nav class="navbar navbar-expand-lg bg-dark" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Timex</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link" href="index.jsp">Home</a>--%>
<%--                </li>--%>
                <%
                    // Check if the user session exists and the user is logged in
                    if (session != null && session.getAttribute("username") != null) {
                %>
                <% if ("admin".equalsIgnoreCase(session.getAttribute("role").toString())) { %>
                <li class="nav-item">
                    <a class="nav-link" href="adminDashboard">Admin</a>
                </li>
                <% } %>
                <li class="nav-item">
                    <a class="nav-link" href="employeeDashboard">Employee Dashboard</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout</a>
                </li>
                <%
                } else {
                %>
                <li class="nav-item">
                    <a class="nav-link" href="login">Login</a>
                </li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>
