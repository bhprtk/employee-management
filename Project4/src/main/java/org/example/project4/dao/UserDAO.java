package org.example.project4.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) class for interacting with the database.
 * Handles operations related to employees and attendance, such as CRUD operations and business-specific queries.
 */
public class UserDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    /**
     * Retrieves the role of a user based on their username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The role of the user (e.g., "admin", "employee"), or null if no match is found.
     */
    public String getUserRole(String username, String password) {
        String query = "SELECT role FROM employees WHERE username = ? AND password = ?";
        String role = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set query parameters
            statement.setString(1, username);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    role = resultSet.getString("role"); // Retrieve the user's role (admin/employee)
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role; // Return the role or null if no match found
    }

    /**
     * Fetches a list of all employees from the database.
     *
     * @return A list of Employee objects containing employee information.
     */
    /**
     * Fetches a list of all employees from the database.
     *
     * @return A list of Employee objects containing employee information.
     */
    public List<Employee> getAllEmployees() {
        // Log message for debugging purposes
        System.out.println("getAllEmployees");

        // SQL query to retrieve employee information
        String query = "SELECT id, firstname, lastname, username, role, email FROM employees";

        // Create a list to hold Employee objects
        List<Employee> employees = new ArrayList<>();

        // Establish a connection to the database and execute the query
        try (
                // Create a connection to the database
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                // Prepare the SQL query to prevent SQL injection
                PreparedStatement statement = connection.prepareStatement(query);

                // Execute the query and store the result in a ResultSet
                ResultSet resultSet = statement.executeQuery()
        ) {

            // Iterate over the ResultSet to extract employee information
            while (resultSet.next()) {
                // Create a new Employee object for each row in the ResultSet
                Employee employee = new Employee();

                // Set the fields of the Employee object using the ResultSet data
                employee.setId(resultSet.getInt("id"));                // Employee ID
                employee.setFirstName(resultSet.getString("firstname")); // Employee first name
                employee.setLastName(resultSet.getString("lastname"));   // Employee last name
                employee.setUsername(resultSet.getString("username"));   // Employee username
                employee.setRole(resultSet.getString("role"));           // Employee role (e.g., admin, employee)
                employee.setEmail(resultSet.getString("email"));         // Employee email

                // Add the populated Employee object to the list
                employees.add(employee);
            }
        } catch (SQLException e) {
            // Print the stack trace for debugging if an SQL exception occurs
            e.printStackTrace();
        }

        // Return the list of employees
        return employees;
    }

    /**
     * Adds a new employee to the database.
     *
     * @param employee The Employee object containing details of the new employee.
     */
    public void addEmployee(Employee employee) {
        String query = "INSERT INTO employees (firstname, lastname, username, role, email, password) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set the values for the query
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getUsername());
            statement.setString(4, employee.getRole());
            statement.setString(5, employee.getEmail());
            statement.setString(6, employee.getPassword());

            // Execute the query
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Employee added successfully.");
            } else {
                System.out.println("Failed to add employee.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error while adding employee: " + e.getMessage());
        }
    }
    /**
     * Retrieves an employee based on their unique ID.
     *
     * @param id The unique ID of the employee.
     * @return An Employee object containing the employee's information, or null if not found.
     */
    public Employee getEmployeeById(int id) {
        String query = "SELECT id, firstname, lastname, username, role, email FROM employees WHERE id = ?";
        Employee employee = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setFirstName(resultSet.getString("firstname"));
                    employee.setLastName(resultSet.getString("lastname"));
                    employee.setUsername(resultSet.getString("username"));
                    employee.setRole(resultSet.getString("role"));
                    employee.setEmail(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    /**
     * Updates an existing employee's information in the database.
     *
     * @param employee The Employee object containing the updated information.
     */
    public void updateEmployee(Employee employee) {
        String query = "UPDATE employees SET firstname = ?, lastname = ?, username = ?, role = ?, email = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getUsername());
            statement.setString(4, employee.getRole());
            statement.setString(5, employee.getEmail());
            statement.setInt(6, employee.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Failed to update employee.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes an employee from the database based on their ID.
     *
     * @param id The unique ID of the employee to delete.
     * @return True if the deletion was successful, false otherwise.
     */
    public boolean deleteEmployeeById(int id) {
        String query = "DELETE FROM employees WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();

            return rowsAffected > 0; // Return true if at least one row was deleted
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Records a clock-in entry for an employee.
     *
     * @param employeeId The unique ID of the employee clocking in.
     * @return True if the clock-in was successful, false otherwise.
     */
    public boolean clockIn(int employeeId) {
        // SQL query to insert a new attendance record with the current time and date
        String query = "INSERT INTO attendance (employee_id, time_in, date) VALUES (?, NOW(), CURDATE())";

        // Establish a database connection and execute the query
        try (
                // Create a connection to the database
                Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                // Prepare the SQL query to prevent SQL injection
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            // Set the employee ID parameter in the prepared statement
            statement.setInt(1, employeeId);

            // Execute the query and store the number of affected rows
            int rowsAffected = statement.executeUpdate();

            // Return true if at least one row was inserted, indicating a successful clock-in
            return rowsAffected > 0;
        } catch (SQLException e) {
            // Print the stack trace for debugging if an SQL exception occurs
            e.printStackTrace();
            return false; // Return false if an exception occurs
        }
    }
    /**
     * Records a clock-out entry for an employee.
     *
     * @param employeeId The unique ID of the employee clocking out.
     * @return True if the clock-out was successful, false otherwise.
     */
    public boolean clockOut(int employeeId) {
        String query = "UPDATE attendance SET time_out = NOW() WHERE employee_id = ? AND time_out IS NULL";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, employeeId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Retrieves the current employee's information by their unique ID.
     *
     * @param employeeId The unique ID of the employee.
     * @return An Employee object containing the employee's information, or null if not found.
     */
    public Employee getCurrentEmployeeById(int employeeId) {
        String query = "SELECT id, firstname, lastname, username, role, email FROM employees WHERE id = ?";
        Employee employee = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set the employee ID parameter
            statement.setInt(1, employeeId);

            // Execute the query
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Populate the employee object
                    employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setFirstName(resultSet.getString("firstname"));
                    employee.setLastName(resultSet.getString("lastname"));
                    employee.setUsername(resultSet.getString("username"));
                    employee.setRole(resultSet.getString("role"));
                    employee.setEmail(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }


    /**
     * Retrieves the current employee's information by their username.
     *
     * @param username The username of the employee.
     * @return An Employee object containing the employee's information, or null if not found.
     */
    public Employee getCurrentEmployeeByUserName(String username) {
        String query = "SELECT id, firstname, lastname, username, role, email FROM employees WHERE username = ?";
        Employee employee = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    // Populate employee object
                    employee = new Employee();
                    employee.setId(resultSet.getInt("id"));
                    employee.setFirstName(resultSet.getString("firstname"));
                    employee.setLastName(resultSet.getString("lastname"));
                    employee.setUsername(resultSet.getString("username"));
                    employee.setRole(resultSet.getString("role"));
                    employee.setEmail(resultSet.getString("email"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employee;
    }
    /**
     * Checks if an employee is currently clocked in.
     *
     * @param employeeId The unique ID of the employee.
     * @return True if the employee is clocked in, false otherwise.
     */
    public boolean isClockedIn(int employeeId) {
        String query = "SELECT COUNT(*) FROM attendance WHERE employee_id = ? AND time_out IS NULL";
        boolean isClockedIn = false;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, employeeId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    isClockedIn = resultSet.getInt(1) > 0; // Returns true if at least one row exists
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isClockedIn;
    }
    /**
     * Retrieves a list of attendance records for a specific employee.
     *
     * @param employeeId The unique ID of the employee.
     * @return A list of Attendance objects containing attendance records.
     */
    public List<Attendance> getAttendanceByEmployeeId(int employeeId) {
        String query = "SELECT id, employee_id, time_in, time_out, date FROM attendance WHERE employee_id = ?";
        List<Attendance> attendanceList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, employeeId);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Attendance attendance = new Attendance();
                    attendance.setId(resultSet.getInt("id"));
                    attendance.setEmployeeId(resultSet.getInt("employee_id")); // Populate employeeId
                    attendance.setTimeIn(resultSet.getTimestamp("time_in"));
                    attendance.setTimeOut(resultSet.getTimestamp("time_out"));
                    attendance.setDate(resultSet.getDate("date"));
                    attendanceList.add(attendance);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }
    /**
     * Retrieves an attendance record by its unique ID.
     *
     * @param id The unique ID of the attendance record.
     * @return An Attendance object containing the attendance details, or null if not found.
     */
    public Attendance getAttendanceById(int id) {
        String query = "SELECT id, employee_id, time_in, time_out, date FROM attendance WHERE id = ?";
        Attendance attendance = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    attendance = new Attendance();
                    attendance.setId(resultSet.getInt("id"));
                    attendance.setEmployeeId(resultSet.getInt("employee_id")); // Populate employeeId
                    attendance.setTimeIn(resultSet.getTimestamp("time_in"));
                    attendance.setTimeOut(resultSet.getTimestamp("time_out"));
                    attendance.setDate(resultSet.getDate("date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendance;
    }
    /**
     * Updates an existing attendance record.
     *
     * @param id       The unique ID of the attendance record.
     * @param date     The updated date of the attendance record.
     * @param timeIn   The updated clock-in time.
     * @param timeOut  The updated clock-out time.
     * @return True if the update was successful, false otherwise.
     */
    public boolean updateAttendance(int id, String date, String timeIn, String timeOut) {
        String query = "UPDATE attendance SET date = ?, time_in = ?, time_out = ? WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, java.sql.Date.valueOf(date));
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(date + " " + timeIn + ":00"));
            statement.setTimestamp(3, timeOut != null && !timeOut.isEmpty()
                    ? java.sql.Timestamp.valueOf(date + " " + timeOut + ":00") : null);
            statement.setInt(4, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Deletes an attendance record by its unique ID.
     *
     * @param id The unique ID of the attendance record to delete.
     * @return True if the deletion was successful, false otherwise.
     */
    public boolean deleteAttendance(int id) {
        String query = "DELETE FROM attendance WHERE id = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}

