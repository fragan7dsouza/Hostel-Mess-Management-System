package com.hostel.dao;

import com.hostel.model.Menu;
import com.hostel.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MenuDAO {

    private static final String insert_menu = "insert into menu (day_of_week, meal_type, item_name) values (?, ?, ?)";
    private static final String select_all_menu = "select * from menu order by field(day_of_week, 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday'), field(meal_type, 'breakfast', 'lunch', 'dinner')";
    private static final String update_menu = "update menu set day_of_week = ?, meal_type = ?, item_name = ? where menu_id = ?";
    private static final String delete_menu = "delete from menu where menu_id = ?";
    private static final String select_menu_by_id = "select menu_id, day_of_week, meal_type, item_name from menu where menu_id = ?";

    public void addMenu(Menu menu) throws SQLException {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(insert_menu)) {
            
            ps.setString(1, menu.getDayOfWeek());
            ps.setString(2, menu.getMealType());
            ps.setString(3, menu.getItemName());
            ps.executeUpdate();
        } 
    }

    public List<Menu> getAllMenu() throws SQLException {
        List<Menu> menuList = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(select_all_menu)) {
            
            while (rs.next()) {
                Menu menu = extractMenuFromResultSet(rs);
                menuList.add(menu);
            }
        }
        return menuList;
    }
    
    public Menu getMenuById(int menuId) throws SQLException {
        Menu menu = null;
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(select_menu_by_id)) {
            
            ps.setInt(1, menuId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    menu = extractMenuFromResultSet(rs);
                }
            }
        }
        return menu;
    }

    
    public boolean updateMenu(Menu menu) throws SQLException {
        boolean rowUpdated;
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(update_menu)) {
            
            ps.setString(1, menu.getDayOfWeek());
            ps.setString(2, menu.getMealType());
            ps.setString(3, menu.getItemName());
            ps.setInt(4, menu.getMenuId());
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteMenu(int menuId) throws SQLException {
        boolean rowDeleted;
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(delete_menu)) {
            
            ps.setInt(1, menuId);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    
    private Menu extractMenuFromResultSet(ResultSet rs) throws SQLException {
        int id = rs.getInt("menu_id");
        String day = rs.getString("day_of_week");
        String meal = rs.getString("meal_type");
        String item = rs.getString("item_name");
        return new Menu(id, day, meal, item);
    }
}