package com.hostel.controller;

import com.hostel.dao.MenuDAO;
import com.hostel.model.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

// servlet annotation: maps the servlet to the url pattern '/menu'
@WebServlet("/menu") 
public class MenuServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MenuDAO menuDAO;

    public void init() {
        menuDAO = new MenuDAO(); 
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; 
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
  
                    break; 
                case "delete":
                    deleteMenu(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
           
                    break;
                default:
                    listMenu(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list"; 
        }

        try {
            switch (action) {
                case "insert":
                    insertMenu(request, response);
                    break;
                case "update":
                    updateMenu(request, response);
                    break;
                default:
                    listMenu(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listMenu(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException, ServletException {
        List<Menu> listMenu = menuDAO.getAllMenu();
        request.setAttribute("listMenu", listMenu);
        request.getRequestDispatcher("menu-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("menu-form.jsp").forward(request, response);
    }
    
    private void insertMenu(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        String dayOfWeek = request.getParameter("dayOfWeek");
        String mealType = request.getParameter("mealType");
        String itemName = request.getParameter("itemName");

        Menu newMenu = new Menu(dayOfWeek, mealType, itemName);
        menuDAO.addMenu(newMenu);
        response.sendRedirect("menu?action=list");
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Menu existingMenu = menuDAO.getMenuById(id);
        request.setAttribute("menu", existingMenu);
        request.getRequestDispatcher("menu-form.jsp").forward(request, response);
    }

    private void updateMenu(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String dayOfWeek = request.getParameter("dayOfWeek");
        String mealType = request.getParameter("mealType");
        String itemName = request.getParameter("itemName");

        Menu menu = new Menu(id, dayOfWeek, mealType, itemName);
        menuDAO.updateMenu(menu);
        response.sendRedirect("menu?action=list");
    }

    private void deleteMenu(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        menuDAO.deleteMenu(id);
        response.sendRedirect("menu?action=list");
    }
}