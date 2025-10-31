# 🍽️ Hostel Mess Management System (HMMS)

A simple and efficient **Java-based web application** designed to manage student mess enrollment, maintain a weekly meal menu, and generate automated monthly bills.  
Built using **JSP, Servlets, JDBC, and MySQL**, and deployed on **Apache Tomcat**, this system provides a seamless solution for hostel mess administration.  

---

## ⚙️ Features

- ✅ **Student Management (`/student`)**  
  - Perform **CRUD operations**: Add, Edit, Delete, and View student records.  
  - Each record includes Roll No, Name, Email, Age, and **Mess Status** (Enrolled/Not Enrolled).  

- ✅ **Menu Management (`/menu`)**  
  - Add and edit a **weekly mess menu** organized by days (**Monday–Sunday**) and meals (**Breakfast, Lunch, Dinner**).  
  - Clean, table-based JSP interface for viewing and updating meals.  

- ✅ **Monthly Billing (`/billing`)**  
  - Automatically filters students with `messStatus = true`.  
  - Generates a fixed **monthly mess bill** of **₹3500.00 per student**.  
  - Displays a bill summary with enrolled students and total mess collection.  

- ✅ **User Interface (JSP + CSS)**  
  - Built using JSP for dynamic rendering.  
  - Styled with `style.css` for a clean, minimal interface with neatly aligned tables and action buttons.  

---

## 🧩 Technical Overview

### 🏗️ Architecture Layers

| Layer | Package | Description |
| :---- | :------- | :----------- |
| **Model (POJO)** | `com.hostel.model` | Defines entities like `Student` and `Menu`. |
| **Data Access Layer (DAO)** | `com.hostel.dao` | Handles CRUD operations with JDBC for `students` and `menu` tables. |
| **Controller (Servlets)** | `com.hostel.controller` | Manages routes and business logic through `StudentServlet`, `MenuServlet`, and `BillingServlet`. |
| **Utility Layer** | `com.hostel.util` | Contains `DBUtil` for establishing database connections using JDBC. |

---

## 📁 Project Structure

```

HostelMessManagementSystem/
│
├── src/
│   ├── com/hostel/model/
│   │   ├── Student.java
│   │   └── Menu.java
│   │
│   ├── com/hostel/dao/
│   │   ├── StudentDAO.java
│   │   └── MenuDAO.java
│   │
│   ├── com/hostel/controller/
│   │   ├── StudentServlet.java
│   │   ├── MenuServlet.java
│   │   └── BillingServlet.java
│   │
│   └── com/hostel/util/
│       └── DBUtil.java
│
├── WebContent/
│   ├── index.jsp
│   ├── student.jsp
│   ├── menu.jsp
│   ├── billing.jsp
│   ├── style.css
│   └── WEB-INF/
│       ├── web.xml
│       └── lib/
│           └── mysql-connector-j-9.5.0.jar
│
└── README.md

````

---

## ⚙️ Setup & Configuration

### 1️⃣ Database Configuration

Create the database and tables in MySQL:

```sql
CREATE DATABASE hostel_mess_db;

USE hostel_mess_db;

CREATE TABLE students (
  roll_no INT PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  age INT,
  mess_status BOOLEAN
);

CREATE TABLE menu (
  id INT PRIMARY KEY AUTO_INCREMENT,
  day VARCHAR(20),
  meal_type VARCHAR(20),
  item VARCHAR(100)
);
````

### 2️⃣ Update `DBUtil.java`

```java
private static final String JDBC_URL = "jdbc:mysql://localhost:3306/hostel_mess_db";
private static final String JDBC_USER = "root";
private static final String JDBC_PASSWORD = "";
private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
```

### 3️⃣ Add Dependency

Place the **MySQL Connector/J** JAR (e.g., `mysql-connector-j-9.5.0.jar`) inside:

```
WebContent/WEB-INF/lib/
```

---

## 🚀 Deployment

**Build your project into a `.war` file:**

```
mvn clean package
```

(or export via **Eclipse → File → Export → WAR File**)

**Deploy the WAR file to Apache Tomcat:**

1. Copy it to `tomcat/webapps/`
2. Start the Tomcat server

**Access in browser:**

```
http://localhost:8080/HostelMessManagementSystem/
```

---

## 💡 Example Usage

### ➕ Add New Student

* Navigate to `/student`
* Fill details and select **Mess Status → "Enrolled"**
* Click **Submit** → Data saved in MySQL

### 🍴 Edit Weekly Menu

* Go to `/menu`
* Update meal items for specific days
* Save changes to update the database

### 🧾 Generate Monthly Bill

* Access `/billing`
* Automatically lists all enrolled students
* Displays total bill amount = **₹3500 × (No. of Enrolled Students)**

---

## 📌 Notes

* All data is stored persistently in **MySQL**.
* Uses **JSP** for server-side rendering and **Servlets** for routing logic.
* Ensure the **Tomcat server** is running before accessing the endpoints.
* Modify `DBUtil.java` if your database credentials differ.

---

## 👨‍💻 Author

**Fragan Dsouza**

📎 [LinkedIn](https://linkedin.com/in/fragan-dsouza)
💻 [GitHub](https://github.com/fragan7dsouza)

---

## 📜 License

This project is **open-source** and free to use under the **MIT License**.
