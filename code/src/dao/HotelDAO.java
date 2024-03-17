package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import model.Hotel;
import util.DBConnection;

public class HotelDAO{

    public Hotel getHotelById(int hotelId) {
        Hotel hotel = new Hotel();
        String sql = "SELECT * FROM hotel WHERE hotelId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, hotelId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hotel.setHotelId(rs.getInt("hotelId"));
                hotel.setStarRating(rs.getString("starRating"));
                hotel.setNRooms(rs.getInt("nRooms"));
                hotel.setAddress(rs.getString("address"));
                hotel.setHotelName(rs.getString("hotelName"));
                hotel.setContactEmails(rs.getString("contactEmails"));
                hotel.setPhoneNumber(rs.getString("phoneNumber"));
                hotel.setChainId(rs.getInt("chainId"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    public String getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotel";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setHotelId(rs.getInt("hotelId"));
                hotel.setStarRating(rs.getString("starRating"));
                hotel.setNRooms(rs.getInt("nRooms"));
                hotel.setAddress(rs.getString("address"));
                hotel.setHotelName(rs.getString("hotelName"));
                hotel.setContactEmails(rs.getString("contactEmails"));
                hotel.setPhoneNumber(rs.getString("phoneNumber"));
                hotel.setChainId(rs.getInt("chainId"));
                hotels.add(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(hotels);
    }

    public String getHotelsByChainId(int chainId) {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotel WHERE chainId = ?";
    
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
    
            pstmt.setInt(1, chainId);
            ResultSet rs = pstmt.executeQuery();
    
            while (rs.next()) {
                // Populate hotel object and add to list
                Hotel hotel = new Hotel();

                hotel.setAddress(rs.getString("Address"));
                hotel.setChainId(rs.getInt("chainid"));
                hotel.setContactEmails(rs.getString("contactemails"));
                hotel.setHotelId(rs.getInt("hotelid"));
                hotel.setHotelName(rs.getString("hotelname"));
                hotel.setNRooms(rs.getInt("nrooms"));
                hotel.setPhoneNumber(rs.getString("phonenumber"));
                hotel.setStarRating(rs.getString("starrating"));


                hotels.add(hotel);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(hotels);
    }
}
