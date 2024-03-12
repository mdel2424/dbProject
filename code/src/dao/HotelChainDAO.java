package dao;

import model.HotelChain;
import util.DBConnection;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HotelChainDAO {

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        // try {
        //     switch (action) {
        //         case "/new":
        //             getAllHotelChains(request, response);
        //             break;
        //         case "/insert":
        //             insertEmployee(request, response);
        //             break;
        //         case "/delete":
        //             deleteEmployee(request, response);
        //             break;
        //         case "/edit":
        //             showEditForm(request, response);
        //             break;
        //         case "/update":
        //             updateEmployee(request, response);
        //             break;
        //         case "/list":
        //             listEmployees(request, response);
        //             break;
        //         default:
        //             listEmployees(request, response);
        //             break;
        //     }
        // } catch (Exception ex) {
        //     throw new ServletException(ex);
        // }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public List<HotelChain> getAllHotelChains() {
        List<HotelChain> hotelChains = new ArrayList<>();
        String sql = "SELECT * FROM HotelChain";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
    
            while (rs.next()) {
                HotelChain hotelChain = new HotelChain();
                hotelChain.setChainId(rs.getInt("ChainId"));
                hotelChain.setNHotels(rs.getInt("NHotels"));
                hotelChain.setHQAddress(rs.getString("HQAddress"));
                hotelChain.setContactEmails(rs.getString("ContactEmails"));
                hotelChain.setPhoneNumber(rs.getString("PhoneNumber"));
                hotelChains.add(hotelChain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotelChains;
    }

    public void deleteHotelChain(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteHotelChain'");
    }

    public HotelChain getHotelChain(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHotelChain'");
    }
    

    // Add methods for Create, Update, and Delete operations.
}
