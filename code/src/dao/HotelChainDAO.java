package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.HotelChain;
import util.DBConnection;

public class HotelChainDAO implements GenericDAO{

    public void init() {
    }


    public List<HotelChain> getAllHotelChains() {
        List<HotelChain> hotelChains = new ArrayList<>();
        String sql = "SELECT * FROM HotelChain";
        
        // Open a connection with the database and talk to the data !
        try (Connection conn = DBConnection.getConnection();
            // PreparedStatements protect from sql injections
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
    
            // Iterate through the returned columns
            while (rs.next()) {
                HotelChain hotelChain = new HotelChain();
                hotelChain.setChainId(rs.getInt("ChainId"));
                hotelChain.setNHotels(rs.getInt("NHotels"));
                hotelChain.setHQAddress(rs.getString("HQAddress"));
                hotelChain.setContactEmails(rs.getString("ContactEmails"));
                hotelChain.setPhoneNumber(rs.getString("PhoneNumber"));
                hotelChain.setHotelChainName(rs.getString("HotelChainName"));
                hotelChains.add(hotelChain);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Return list of HotelChain
        return hotelChains;
    }

    public String getAllJson() {
        // This is what is ultimately called in the DataServlet, since better to work with json on the web (in our case) (dont quote me on that)
        List<HotelChain> hotelChains = getAllHotelChains();
        Gson gson = new Gson();
        return gson.toJson(hotelChains);
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
