package org.example.project4.dao;

/**
 * Represents an employee in the system.
 * This class contains information about the employee's personal details,
 * authentication credentials, and their role in the organization.
 */
public class Employee {

    /**
     * The unique identifier for the employee.
     */
    private int id;

    /**
     * The first name of the employee.
     */
    private String firstName;

    /**
     * The last name of the employee.
     */
    private String lastName;

    /**
     * The username used for the employee's login.
     */
    private String username;

    /**
     * The role of the employee (e.g., admin or employee).
     */
    private String role;

    /**
     * The email address of the employee.
     */
    private String email;

    /**
     * The hashed password for the employee's account.
     */
    private String password;

    /**
     * Default constructor for creating an empty Employee object.
     */
    public Employee() {
    }

    // Getters and Setters

    /**
     * Gets the unique identifier of the employee.
     *
     * @return the employee ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the employee.
     *
     * @param id the employee ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the employee.
     *
     * @return the first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee.
     *
     * @param firstName the first name to set for the employee.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the employee.
     *
     * @return the last name of the employee.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee.
     *
     * @param lastName the last name to set for the employee.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the username of the employee.
     *
     * @return the username of the employee.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username of the employee.
     *
     * @param username the username to set for the employee.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the role of the employee.
     *
     * @return the role of the employee (e.g., admin or employee).
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role of the employee.
     *
     * @param role the role to set for the employee.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the email address of the employee.
     *
     * @return the email address of the employee.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the employee.
     *
     * @param email the email address to set for the employee.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the employee.
     *
     * @return the hashed password of the employee.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the employee.
     *
     * @param password the hashed password to set for the employee.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
