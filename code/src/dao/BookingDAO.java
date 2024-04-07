package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import model.Booking;
import util.DBConnection;

public class BookingDAO{

    // Method to retrieve all bookings
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM Booking";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("BookingId"));
                booking.setStatus(rs.getString("Status"));
                booking.setStartDate(rs.getDate("StartDate"));
                booking.setEndDate(rs.getDate("EndDate"));
                booking.setRoomId(rs.getInt("RoomId"));
                booking.setClientId(rs.getInt("ClientId"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    public String getBookingsFromQuery(Map<String, String[]> arguments) {
        StringBuilder sql = new StringBuilder(
            "SELECT B.*, C.fullname AS clientName, R.roomnumber AS roomNumber FROM Booking B " +
            "INNER JOIN Client C ON B.clientId = C.ssn " +
            "INNER JOIN Room R ON B.roomId = R.roomid"
        );
        
        if (!arguments.isEmpty()) {
            sql.append(" WHERE ");
            boolean first = true;
        
            // Assuming 'name' is a criteria to filter clients
            if (arguments.containsKey("bookingName")) {
                String name = arguments.get("bookingName")[0]; // Assuming arguments is a Map<String, String[]>
                if (!first) sql.append(" AND ");
                sql.append("C.fullname = '").append(name.replace("'", "''")).append("'");
                first = false;
            }
        }
        List<Booking> bookings = new ArrayList<>();

        System.out.println(sql.toString());
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql.toString());
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Booking booking = new Booking();
                booking.setBookingId(rs.getInt("bookingId"));
                booking.setStatus(rs.getString("Status"));
                booking.setStartDate(rs.getDate("startDate"));
                booking.setEndDate(rs.getDate("endDate"));
                booking.setRoomId(rs.getInt("roomId"));
                booking.setClientId(rs.getInt("clientId"));
                booking.setClientName(rs.getString("clientName"));
                booking.setRoomNumber(rs.getInt("roomNumber"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        return gson.toJson(bookings);
    }


    public boolean insertBooking(Booking booking) {
        String sql = "INSERT INTO Booking (\"Status\", StartDate, EndDate, RoomId, ClientId) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, booking.getStatus());
            pstmt.setDate(2, booking.getStartDate());
            pstmt.setDate(3, booking.getEndDate());
            pstmt.setInt(4, booking.getRoomId());
            pstmt.setInt(5, booking.getClientId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
