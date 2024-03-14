package dao;

import model.Hotel;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO {

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

    public List<Hotel> getAllHotels() {
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
        return hotels;
    }

    // Implement other CRUD operations (create, update, delete) here.
}
