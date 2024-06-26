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

    public Hotel getHotelById(String hotelIdS) {
        int hotelId = Integer.parseInt(hotelIdS);
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

    public String getHotelsByChainId(String chainIdS) {
        int chainId = Integer.parseInt(chainIdS);
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

    public boolean insertHotel(Hotel hotel) {
        String sql = "INSERT INTO Hotel (StarRating, NRooms, \"Address\", HotelName, ContactEmails, PhoneNumber, ChainID) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(2, hotel.getNRooms());
            pstmt.setString(3, hotel.getAddress());
            pstmt.setString(4, hotel.getHotelName());
            pstmt.setArray(5, conn.createArrayOf("VARCHAR", hotel.getContactEmails().split(",")));
            pstmt.setString(6, hotel.getPhoneNumber());
            pstmt.setInt(7, hotel.getChainId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
