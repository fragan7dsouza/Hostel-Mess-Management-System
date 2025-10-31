<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Hostel Mess Management System</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"> 
</head>
<body>
    <div class="container">
        <h1>Hostel Mess Management System</h1>
        
        <div class="card">
            <h2>Modules</h2>
            <p>
                <a href="menu?action=list" class="btn btn-primary">View/Manage Weekly Menu</a>
            </p>
            <p>
                <a href="student?action=list" class="btn btn-primary">Manage Students (Enrollment)</a>
            </p>
            <p>
                <a href="billing" class="btn btn-primary">Generate Monthly Bill</a>
            </p>
        </div>
    </div>
</body>
</html>