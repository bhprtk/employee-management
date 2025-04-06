# 🕒 Employee Clock-In and Attendance Management System

## 📌 Project Overview
The **Employee Clock-In and Attendance Management System** is a web-based Java application designed to streamline attendance tracking for organizations. Employees can securely clock in and out, while administrators manage employee records and generate timesheets. Key features include role-based access control, secure authentication, and a scalable backend built with Java and MySQL.

---

## 🧰 Tech Stack

- **Backend**: Java, Jakarta Servlet API 6.1.0  
- **Frontend**: HTML, CSS, Bootstrap (via CDN)  
- **Database**: MySQL  
- **Server**: Apache Tomcat 10  
- **Build Tool**: IntelliJ IDEA (manual deployment)

---

## 🚀 Setup Instructions

### ✅ Prerequisites
- Java Development Kit (JDK) 11+
- Apache Tomcat 10+
- MySQL Server
- IntelliJ IDEA or compatible IDE

---

### 🛠️ Installation & Configuration

1. **Extract the Codebase**
   - Download `Project4` folder.

2. **Import the Project**
   - Open IntelliJ IDEA → **File > Open** → Select the project directory.

3. **Database Setup**
   - In MySQL, run the following:
     ```sql
     CREATE DATABASE testdb;
     USE testdb;
     SOURCE create_schema.sql;
     SOURCE initialize_data.sql;
     ```
   - Update DB credentials in `UserDAO.java`:
     ```java
     private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
     private static final String DB_USER = "root";
     private static final String DB_PASSWORD = "your_password";
     ```

4. **Tomcat Configuration**
   - Run > Edit Configurations > Add New > Tomcat Server
   - Set deployment directory to the project’s `web` folder

5. **Run the App**
   - Start Tomcat and visit:  
     ```
     http://localhost:8080/
     ```

---

## 📦 Dependencies

- Jakarta Servlet API 6.1.0  
- MySQL Connector/J 8.0+  
- Bootstrap (via CDN)

---

## ⚙️ Additional Configuration

- **Database Privileges**:
  ```sql
  GRANT ALL PRIVILEGES ON testdb.* TO 'root'@'localhost' IDENTIFIED BY 'your_password';
  FLUSH PRIVILEGES;
  ```

- **Testing Data Example**:
  ```sql
  INSERT INTO employees (firstname, lastname, username, email, password, role) VALUES
  ('John', 'Doe', 'johndoe', 'john.doe@example.com', 'hashed_password', 'employee');
  ```

---

## 💡 Future Improvements

- Email notifications on clock-in/out
- Exportable timesheets (PDF/CSV)
- Admin analytics dashboard

---

## 📄 License

This project is licensed under the **MIT License**.  
See the [LICENSE](./LICENSE) file for details.

---

## 👤 Author

Developed by [Pratik Bhandari](https://bhprtk.com)

---

