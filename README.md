# Employee Clock-In and Attendance Management System

## Project Overview
The **Employee Clock-In and Attendance Management System** is a web-based application designed to streamline attendance tracking for organizations. Employees can clock in and out to record their attendance, while administrators can manage employee records and timesheets. The system incorporates features like role-based access, secure authentication, and scalable design.

---

## Instructions for Setting Up and Running the Project

### Prerequisites
1. **Java Development Kit (JDK)**: Version 11 or above.
2. **Apache Tomcat**: Version 10 or above.
3. **MySQL Server**: Installed and running.
4. **IntelliJ IDEA** (or any Java IDE): For code execution and deployment.

---

### Setup Instructions
1. **Extract the Codebase**:
   - Download the zip file and extract it to your preferred directory.

2. **Import the Project**:
   - Open IntelliJ IDEA (or any Java IDE).
   - Select **Open** and navigate to the extracted project directory.

3. **Database Setup**:
   - Open a MySQL client or GUI (e.g., MySQL Workbench or the command line).
   - Create the database and import the schema:
     ```sql
     CREATE DATABASE testdb;
     USE testdb;
     SOURCE create_schema.sql;
     ```
   - To populate the database with initial testing data, run:
     ```sql
     SOURCE initialize_data.sql;
     ```
   - Update the database configuration in `UserDAO.java`:
     ```java
     private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
     private static final String DB_USER = "root";
     private static final String DB_PASSWORD = "your_password";
     ```

4. **Configure Tomcat**:
   - In IntelliJ, go to **Run > Edit Configurations**.
   - Add a new **Tomcat Server** configuration.
   - Set the deployment directory to the project’s `web` folder.

5. **Run the Application**:
   - Start the Tomcat server from IntelliJ.
   - Open a web browser and navigate to:
     ```
     http://localhost:8080/
     ```

---

## Dependencies and Required Software
- **Java**: Version 11 or above.
- **Jakarta Servlet API**: Version 6.1.0.
- **MySQL Connector/J**: Version 8.0 or above.
- **Bootstrap**: For front-end design (included via CDN).

---

## Additional Configuration Steps
1. **Database Credentials**:
   - Ensure that the `DB_URL`, `DB_USER`, and `DB_PASSWORD` in `UserDAO.java` match your MySQL setup.
   - Grant necessary privileges to the database user:
     ```sql
     GRANT ALL PRIVILEGES ON testdb.* TO 'root'@'localhost' IDENTIFIED BY 'your_password';
     FLUSH PRIVILEGES;
     ```

2. **Port Configuration**:
   - If Tomcat is running on a port other than `8080`, update the URL accordingly.

3. **Optional Testing Data**:
   - Use the provided sample SQL queries to populate the `employees` and `attendance` tables with additional data for testing:
     ```sql
     INSERT INTO employees (firstname, lastname, username, email, password, role) VALUES
     ('John', 'Doe', 'johndoe', 'john.doe@example.com', 'hashed_password', 'employee');
     ```

---

Feel free to reach out if you encounter any issues during setup. Enjoy using the Employee Clock-In and Attendance Management System!
