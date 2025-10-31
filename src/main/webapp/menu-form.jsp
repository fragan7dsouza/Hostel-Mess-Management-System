<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hostel.model.Menu"%>

<html>
<head>
    <title>Manage Menu Item</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">
        <%
  
            Menu existingMenu = (Menu) request.getAttribute("menu");
            
      
            String title = (existingMenu != null) ? "Edit Menu Item" : "Add New Menu Item";
            String action = (existingMenu != null) ? "update" : "insert";
        %>
        
        <h1><%= title %></h1>
        
        <div class="card">
            <form action="menu" method="post">
                
                <input type="hidden" name="action" value="<%= action %>">
                
                <%
                    if (existingMenu != null) {
                %>
                    <input type="hidden" name="id" value="<%= existingMenu.getMenuId() %>">
                    <p>Menu ID: **<%= existingMenu.getMenuId() %>**</p>
                <%
                    }
                %>
                
                <table>
                    <tr>
                        <td>Day of Week:</td>
                        <td>
                            <select name="dayOfWeek" required>
                                <option value="">-- select day --</option>
                                
                                <% 
                                    String selectedDay = (existingMenu != null) ? existingMenu.getDayOfWeek() : "";
                                    String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};
                                    
                                    for (String day : days) {
                                        String selected = day.equalsIgnoreCase(selectedDay) ? "selected" : "";
                                %>
                                        <option value="<%= day %>" <%= selected %>>
                                            <%= day.substring(0, 1).toUpperCase() + day.substring(1) %>
                                        </option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Meal Type:</td>
                        <td>
                            <select name="mealType" required>
                                <option value="">-- select meal --</option>
                                
                                <% 
                                    String selectedMeal = (existingMenu != null) ? existingMenu.getMealType() : "";
                                    String[] meals = {"breakfast", "lunch", "dinner"};
                                    
                                    for (String meal : meals) {
                                        String selected = meal.equalsIgnoreCase(selectedMeal) ? "selected" : "";
                                %>
                                        <option value="<%= meal %>" <%= selected %>>
                                            <%= meal.substring(0, 1).toUpperCase() + meal.substring(1) %>
                                        </option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>Item Name:</td>
                        <td>
                            <input type="text" name="itemName" required 
                                value="<%= (existingMenu != null) ? existingMenu.getItemName() : "" %>">
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="2" style="text-align:center;">
                            <input type="submit" value="Save Menu Item" class="btn btn-primary">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        
        <a href="menu?action=list">Back to Menu List</a>
    </div>
</body>
</html>