package com.hostel.dao;

import com.hostel.model.Student;
import com.hostel.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private static final String insert_student = "insert into students (roll_no, name, email, age, mess_status) values (?, ?, ?, ?, ?)";
    private static final String select_all_students = "select * from students order by roll_no";
    private static final String select_student_by_rollno = "select roll_no, name, email, age, mess_status from students where roll_no = ?";
    private static final String update_student = "update students set name = ?, email = ?, age = ?, mess_status = ? where roll_no = ?";
    private static final String delete_student = "delete from students where roll_no = ?";
    private Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
        int rollNo = rs.getInt("roll_no");
        String name = rs.getString("name");
        String email = rs.getString("email");
        int age = rs.getInt("age");
        boolean messStatus = rs.getBoolean("mess_status");
        return new Student(rollNo, name, email, age, messStatus);
    }
    
    public void addStudent(Student student) throws SQLException {
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(insert_student)) {
            
            ps.setInt(1, student.getRollNo());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.setInt(4, student.getAge());
            ps.setBoolean(5, student.isMessStatus()); 
            ps.executeUpdate();
        } 
    }

    public List<Student> getAllStudents() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(select_all_students)) {
            
            while (rs.next()) {
                Student student = extractStudentFromResultSet(rs);
                studentList.add(student);
            }
        }
        return studentList;
    }
    
    public Student getStudentByRollNo(int rollNo) throws SQLException {
        Student student = null;
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(select_student_by_rollno)) {
            
            ps.setInt(1, rollNo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    student = extractStudentFromResultSet(rs);
                }
            }
        }
        return student;
    }

    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(update_student)) {
            
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setBoolean(4, student.isMessStatus()); 
            ps.setInt(5, student.getRollNo());
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteStudent(int rollNo) throws SQLException {
        boolean rowDeleted;
        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(delete_student)) {
            
            ps.setInt(1, rollNo);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}