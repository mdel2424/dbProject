package com.app.dao;

import com.app.model.HotelChain;
import com.app.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelChainDAO {
    
    private final String JDBC_URL = "jdbc:postgresql://localhost/yourDatabase"; // replace with your database URL
    private final String JDBC_USER = "yourUsername"; // replace with your database username
    private final String JDBC_PASS = "yourPassword"; // replace with your database password

    public HotelChainDAO() {
        // You could also manage the JDBC driver loading here, if necessary.
        // For example: Class.forName("org.postgresql.Driver");
    }

    public List<HotelChain> getAllHotelChains() {
        List<HotelChain> hotelChains = new ArrayList<>();
        String sql = "SELECT * FROM HotelChain";

        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                HotelChain chain = new HotelChain();
                chain.setChainId(rs.getInt("ChainId"));
                chain.setNHotels(rs.getInt("NHotels"));
                chain.setHqAddress(rs.getString("HQAddress"));
                chain.setContactEmails(rs.getString("ContactEmails"));
                chain.setPhoneNumber(rs.getString("PhoneNumber"));
                hotelChains.add(chain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelChains;
    }

    // Add methods for Create, Update, and Delete operations.
}
