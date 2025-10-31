<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.hostel.model.Student"%>

<html>
<head>
    <title>Student Management List</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"> 
</head>
<body>
    <div class="container">
        <h1>Student Management</h1>
        
        <a href="student?action=new" class="btn btn-primary">Add New Student</a>
        
        <div class="card">
            <table class="data-table">
                <tr>
                    <th>Roll No</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                    <th>Mess Status</th>
                    <th>Actions</th>
                </tr>
                
                <% 
                    List<Student> listStudents = (List<Student>) request.getAttribute("listStudents");
                    
                    if (listStudents != null && !listStudents.isEmpty()) {
                        for (Student student : listStudents) {
                %>
                <tr>
                    <td><%= student.getRollNo() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getEmail() %></td>
                    <td><%= student.getAge() %></td>
                    <td>
                        <%= student.isMessStatus() ? "Enrolled" : "Not Enrolled" %>
                    </td>
                    <td>
                        <a href="student?action=edit&rollNo=<%= student.getRollNo() %>" class="btn btn-small btn-primary">Edit</a> 
                        <a href="student?action=delete&rollNo=<%= student.getRollNo() %>" class="btn btn-small btn-danger" onclick="return confirm('Are you sure you want to delete student <%= student.getName() %>?');">Delete</a>
                    </td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6">No student records found.</td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        <a href="index.jsp">Back to Home</a>
    </div>
</body>
</html>