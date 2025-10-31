<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hostel.model.Student"%>

<html>
<head>
    <title>Manage Student Record</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        
        <%
            Student existingStudent = (Student) request.getAttribute("student");
            
            String title = (existingStudent != null) ? "Edit Student Details" : "Add New Student";
            String action = (existingStudent != null) ? "update" : "insert";
            
            String rollNoValue = (existingStudent != null) ? String.valueOf(existingStudent.getRollNo()) : "";
            String nameValue = (existingStudent != null) ? existingStudent.getName() : "";
            String emailValue = (existingStudent != null) ? existingStudent.getEmail() : "";
            String ageValue = (existingStudent != null) ? String.valueOf(existingStudent.getAge()) : "";
            boolean messStatusChecked = (existingStudent != null) ? existingStudent.isMessStatus() : false;
            String rollNoReadOnly = (existingStudent != null) ? "readonly" : ""; 
        %>
        
        <h1><%= title %></h1>
        
        <div class="card">
            <form action="student" method="post">
                
                <input type="hidden" name="action" value="<%= action %>">
                
                <table>
                    <tr>
                        <td>Roll No:</td>
                        <td>
                            <input type="text" name="rollNo" required <%= rollNoReadOnly %> 
                                value="<%= rollNoValue %>">
                            <% if (existingStudent != null) { %>
                                <input type="hidden" name="rollNo" value="<%= rollNoValue %>">
                            <% } %>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Name:</td>
                        <td>
                            <input type="text" name="name" required value="<%= nameValue %>">
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Email:</td>
                        <td>
                            <input type="text" name="email" value="<%= emailValue %>">
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Age:</td>
                        <td>
                            <input type="number" name="age" value="<%= ageValue %>">
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Mess Enrollment:</td>
                        <td>
                            <input type="checkbox" name="messStatus" value="on" 
                                <%= messStatusChecked ? "checked" : "" %>> 
                            Currently Enrolled
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2" style="text-align:center;">
                            <input type="submit" value="Save Student Record" class="btn btn-primary">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        
        <a href="student?action=list">Back to Student List</a>
    </div>
</body>
</html>