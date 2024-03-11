package com.app.dao;

import com.app.model.Employee;
import com.app.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public Employee getEmployeeBySSN(String ssn) {
        Employee employee = null;
        String sql = "SELECT * FROM Employee WHERE ssn = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, ssn);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                employee = new Employee();
                employee.setSsn(rs.getString("ssn"));
                employee.setFullName(rs.getString("fullname"));
                employee.setAddress(rs.getString("address"));
                employee.setRole(rs.getString("role"));
                employee.setHotelId(rs.getInt("hotelid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return employee;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Employee emp = new Employee();
                emp.setSsn(rs.getString("ssn"));
                emp.setFullName(rs.getString("fullname"));
                emp.setAddress(rs.getString("address"));
                emp.setRole(rs.getString("role"));
                emp.setHotelId(rs.getInt("hotelid"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return employees;
    }

    // Implement create, update, delete methods as needed
}
