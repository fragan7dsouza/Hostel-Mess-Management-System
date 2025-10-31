package com.hostel.mess.util; // use your actual package if needed

import java.sql.Connection;

import com.hostel.util.DBUtil;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DBUtil.getConnection()) {
            System.out.println("✅ Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
