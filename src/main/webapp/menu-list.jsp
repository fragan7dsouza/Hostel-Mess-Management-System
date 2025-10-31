<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.hostel.model.Menu"%>

<html>
<head>
    <title>Weekly Menu List</title>
    <link rel="stylesheet" type="text/css" href="css/style.css"> 
</head>
<body>
    <div class="container">
        <h1>Weekly Mess Menu</h1>
        
        <a href="menu?action=new" class="btn btn-primary">Add New Menu Item</a>
        
        <div class="card">
            <table class="data-table">
                <tr>
                    <th>ID</th>
                    <th>Day</th>
                    <th>Meal Type</th>
                    <th>Item Name</th>
                    <th>Actions</th>
                </tr>
                
                <% 
                    List<Menu> listMenu = (List<Menu>) request.getAttribute("listMenu");
                    
                    if (listMenu != null) {
                        for (Menu menu : listMenu) {
                %>
                <tr>
                    <td><%= menu.getMenuId() %></td>
                    <td><%= menu.getDayOfWeek() %></td>
                    <td><%= menu.getMealType() %></td>
                    <td><%= menu.getItemName() %></td>
                    <td>
                        <a href="menu?action=edit&id=<%= menu.getMenuId() %>" class="btn btn-small btn-primary">Edit</a> 
                        <a href="menu?action=delete&id=<%= menu.getMenuId() %>" class="btn btn-small btn-danger" onclick="return confirm('Are you sure you want to delete this menu item?');">Delete</a>
                    </td>
                </tr>
                <% 
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">No menu items found.</td>
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