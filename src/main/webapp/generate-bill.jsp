<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.hostel.model.Student"%>
<%@page import="com.hostel.util.DBUtil"%>

<html>
<head>
    <title>Monthly Billing Report</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        
        <%
            List<Student> enrolledStudents = (List<Student>) request.getAttribute("enrolledStudents");
            double monthlyFee = (Double) request.getAttribute("monthlyFee");
        %>
        
        <h1>Monthly Mess Bill Generation</h1>
        
        <div class="card">
            <p style="font-size: 1.1em; font-weight: 600;">
                Fixed Monthly Mess Fee: ₹ <%= String.format("%.2f", monthlyFee) %>
            </p>
            <p style="font-size: 0.9em; color: #777;">
                *This bill is generated for all students currently marked as 'enrolled' in the system.*
            </p>
        </div>
        
        <div class="card">
            <h2>Students Due</h2>
            <table class="data-table">
                <tr>
                    <th>Roll No</th>
                    <th>Student Name</th>
                    <th>Email</th>
                    <th>Mess Status</th>
                    <th>Monthly Fee Due (₹)</th>
                </tr>
                
                <% 
                    if (enrolledStudents != null && !enrolledStudents.isEmpty()) {
                        for (Student student : enrolledStudents) {
                %>
                <tr>
                    <td><%= student.getRollNo() %></td>
                    <td><%= student.getName() %></td>
                    <td><%= student.getEmail() %></td>
                    <td>Enrolled</td>
                    <td><%= String.format("%.2f", monthlyFee) %></td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">No students are currently enrolled in the mess.</td>
                </tr>
                <%
                    }
                %>
            </table>
        </div>
        <br>
        <a href="index.jsp">Back to Home</a>
    </div>
</body>
</html>