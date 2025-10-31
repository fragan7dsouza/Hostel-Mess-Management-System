package com.hostel.controller;

import com.hostel.dao.StudentDAO;
import com.hostel.model.Student;
import com.hostel.util.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/billing")
public class BillingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            generateBill(request, response);
        } catch (SQLException ex) {
            throw new ServletException("error generating bill: " + ex.getMessage(), ex);
        }
    }

    private void generateBill(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        List<Student> allStudents = studentDAO.getAllStudents();

        List<Student> enrolledStudents = allStudents.stream()
                .filter(Student::isMessStatus)
                .collect(Collectors.toList());

        request.setAttribute("enrolledStudents", enrolledStudents);
        request.setAttribute("monthlyFee", DBUtil.MONTHLY_MESS_FEE);
        
        request.getRequestDispatcher("generate-bill.jsp").forward(request, response);
    }
}